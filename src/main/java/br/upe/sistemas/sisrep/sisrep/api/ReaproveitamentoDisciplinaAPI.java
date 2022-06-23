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
import br.upe.sistemas.sisrep.sisrep.api.vos.DispensaVO;
import br.upe.sistemas.sisrep.sisrep.api.vos.FichaDispensaVO;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.Dispensa;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.DispensaServico;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa.FichaDispensa;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa.FichaDispensaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class ReaproveitamentoDisciplinaAPI {

  private final DispensaServico dispensaServico;
  private final FichaDispensaServico fichaServico;

  @GetMapping("/dispensas")
  public ResponseEntity<List<DispensaVO>> listarDispensas() {
    return ResponseEntity.ok(dispensaServico.listar().stream().map((e) -> convertToDispensaVo(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/dispensa")
  public ResponseEntity<DispensaVO> incluirDispensa(@RequestBody DispensaVO fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/dispensa").toUriString());

    Dispensa ficha = convertToDispensaModel(fichaVo);
    DispensaVO vo = convertToDispensaVo(dispensaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar dispensa

  @DeleteMapping("/dispensa/{id}")
  public void excluirDispensa(@PathVariable Long id) {
    dispensaServico.excluir(id);
  }

  private DispensaVO convertToDispensaVo(Dispensa dispensa) {
    DispensaVO vo = DispensaVO.builder().id(dispensa.getId()).disciplina(dispensa.getDisciplina())
        .status(dispensa.getStatus()).build();

    return vo;
  }

  private Dispensa convertToDispensaModel(DispensaVO vo) {
    return Dispensa.builder().id(vo.getId()).disciplina(vo.getDisciplina()).status(vo.getStatus())
        .build();
  }

  @GetMapping("/fichas")
  public ResponseEntity<List<FichaDispensaVO>> listarFichasDispensa() {
    return ResponseEntity.ok(fichaServico.listar().stream().map((e) -> convertToFichaDispensaVo(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/ficha")
  public ResponseEntity<FichaDispensaVO> incluirFicha(@RequestBody FichaDispensaVO fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/ficha").toUriString());

    FichaDispensa ficha = convertToFichaDispensaModel(fichaVo);
    FichaDispensaVO vo = convertToFichaDispensaVo(fichaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar ficha

  @DeleteMapping("/ficha/{id}")
  public void excluirFicha(@PathVariable Long id) {
    fichaServico.excluir(id);
  }

  private FichaDispensaVO convertToFichaDispensaVo(FichaDispensa ficha) {
    FichaDispensaVO vo =
        FichaDispensaVO.builder().id(ficha.getId()).requerente(ficha.getRequerente())
            .emailReceptorSolicitacao(ficha.getEmailReceptorSolicitacao())
            .emailEmissorParecer(ficha.getEmailEmissorParecer())
            .emailAnalistaParecer(ficha.getEmailAnalistaParecer())
            .dispensaDisciplina(ficha.getDispensaDisciplina()).build();

    return vo;
  }

  private FichaDispensa convertToFichaDispensaModel(FichaDispensaVO vo) {
    return FichaDispensa.builder().id(vo.getId()).requerente(vo.getRequerente())
        .emailReceptorSolicitacao(vo.getEmailReceptorSolicitacao())
        .emailEmissorParecer(vo.getEmailEmissorParecer())
        .emailAnalistaParecer(vo.getEmailAnalistaParecer())
        .dispensaDisciplina(vo.getDispensaDisciplina()).build();
  }

}
