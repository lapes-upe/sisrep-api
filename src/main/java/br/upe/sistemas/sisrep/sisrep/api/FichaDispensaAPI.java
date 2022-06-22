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
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.Dispensa;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.DispensaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class FichaDispensaAPI {

  private final DispensaServico fichaServico;

  @GetMapping("/fichas")
  public ResponseEntity<List<FichaDispensaVO>> listarFichasDispensa() {
    return ResponseEntity
        .ok(fichaServico.listar().stream().map((e) -> convertToVo(e)).collect(Collectors.toList()));
  }

  @PostMapping("/ficha")
  public ResponseEntity<FichaDispensaVO> incluirFicha(@RequestBody FichaDispensaVO fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/ficha").toUriString());

    Dispensa ficha = convertToModel(fichaVo);
    FichaDispensaVO vo = convertToVo(fichaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar ficha de dispensa

  @DeleteMapping("/ficha/{id}")
  public void excluirFicha(@PathVariable Long id) {
    fichaServico.excluir(id);
  }

  private FichaDispensaVO convertToVo(Dispensa dispensa) {
    FichaDispensaVO vo = FichaDispensaVO.builder().id(dispensa.getId())
        .disciplina(dispensa.getDisciplina()).status(dispensa.getStatus())
        .documentacao(dispensa.getDocumentacao()).build();

    return vo;
  }

  private Dispensa convertToModel(FichaDispensaVO vo) {
    return Dispensa.builder().id(vo.getId()).disciplina(vo.getDisciplina())
        .status(vo.getStatus()).documentacao(vo.getDocumentacao()).build();
  }
}
