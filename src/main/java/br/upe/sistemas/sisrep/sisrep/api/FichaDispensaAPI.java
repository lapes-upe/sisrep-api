package br.upe.sistemas.sisrep.sisrep.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.upe.sistemas.sisrep.sisrep.api.vos.FichaDispensaVO;
import br.upe.sistemas.sisrep.sisrep.core.fichaDispensa.FichaDispensa;
import br.upe.sistemas.sisrep.sisrep.core.fichaDispensa.FichaDispensaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class FichaDispensaAPI {

  private final FichaDispensaServico fichaServico;

  @GetMapping("/fichas")
  public ResponseEntity<List<FichaDispensaVO>> listarFichasDispensa() {
    return ResponseEntity
        .ok(fichaServico.listar().stream().map((e) -> convertToVo(e)).collect(Collectors.toList()));
  }

  @PostMapping("/ficha")
  public ResponseEntity<FichaDispensaVO> incluirFicha(@RequestBody FichaDispensaVO fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/ficha").toUriString());

    FichaDispensa ficha = convertToModel(fichaVo);
    FichaDispensaVO vo = convertToVo(fichaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar ficha de dispensa

  @DeleteMapping("/ficha/{id}")
  public void excluirFicha(@PathVariable Long id) {
    fichaServico.excluir(id);
  }

  private FichaDispensaVO convertToVo(FichaDispensa fichaDispensa) {
    FichaDispensaVO vo = FichaDispensaVO.builder().id(fichaDispensa.getId())
        .disciplinas(fichaDispensa.getDisciplinas()).status(fichaDispensa.getStatus())
        .documentacao(fichaDispensa.getDocumentacao()).build();

    return vo;
  }

  private FichaDispensa convertToModel(FichaDispensaVO vo) {
    return FichaDispensa.builder().id(vo.getId()).disciplinas(vo.getDisciplinas())
        .status(vo.getStatus()).documentacao(vo.getDocumentacao()).build();
  }
}
