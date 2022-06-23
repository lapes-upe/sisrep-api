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
import br.upe.sistemas.sisrep.sisrep.api.envelope.DispensaEnvelope;
import br.upe.sistemas.sisrep.sisrep.api.envelope.FichaDispensaEnvelope;
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
  public ResponseEntity<List<DispensaEnvelope>> listarDispensas() {
    return ResponseEntity.ok(dispensaServico.listar().stream().map((e) -> convertToDispensaVo(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/dispensa")
  public ResponseEntity<DispensaEnvelope> incluirDispensa(@RequestBody DispensaEnvelope fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/dispensa").toUriString());

    Dispensa ficha = convertToDispensaModel(fichaVo);
    DispensaEnvelope vo = convertToDispensaVo(dispensaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar dispensa

  @DeleteMapping("/dispensa/{id}")
  public void excluirDispensa(@PathVariable Long id) {
    dispensaServico.excluir(id);
  }

  private DispensaEnvelope convertToDispensaVo(Dispensa dispensa) {
    DispensaEnvelope vo = DispensaEnvelope.builder().id(dispensa.getId()).disciplina(dispensa.getDisciplina())
        .status(dispensa.getStatus()).build();

    return vo;
  }

  private Dispensa convertToDispensaModel(DispensaEnvelope vo) {
    return Dispensa.builder().id(vo.getId()).disciplina(vo.getDisciplina()).status(vo.getStatus())
        .build();
  }

  @GetMapping("/fichas")
  public ResponseEntity<List<FichaDispensaEnvelope>> listarFichasDispensa() {
    return ResponseEntity.ok(fichaServico.listar().stream().map((e) -> convertToFichaDispensaVo(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/ficha")
  public ResponseEntity<FichaDispensaEnvelope> incluirFicha(@RequestBody FichaDispensaEnvelope fichaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/ficha").toUriString());

    FichaDispensa ficha = convertToFichaDispensaModel(fichaVo);
    FichaDispensaEnvelope vo = convertToFichaDispensaVo(fichaServico.incluir(ficha));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar ficha

  @DeleteMapping("/ficha/{id}")
  public void excluirFicha(@PathVariable Long id) {
    fichaServico.excluir(id);
  }

  private FichaDispensaEnvelope convertToFichaDispensaVo(FichaDispensa ficha) {
    FichaDispensaEnvelope vo =
        FichaDispensaEnvelope.builder().id(ficha.getId()).requerente(ficha.getRequerente())
            .emailReceptorSolicitacao(ficha.getEmailReceptorSolicitacao())
            .emailEmissorParecer(ficha.getEmailEmissorParecer())
            .emailAnalistaParecer(ficha.getEmailAnalistaParecer())
            .dispensaDisciplina(ficha.getDispensaDisciplina()).build();

    return vo;
  }

  private FichaDispensa convertToFichaDispensaModel(FichaDispensaEnvelope vo) {
    return FichaDispensa.builder().id(vo.getId()).requerente(vo.getRequerente())
        .emailReceptorSolicitacao(vo.getEmailReceptorSolicitacao())
        .emailEmissorParecer(vo.getEmailEmissorParecer())
        .emailAnalistaParecer(vo.getEmailAnalistaParecer())
        .dispensaDisciplina(vo.getDispensaDisciplina()).build();
  }

}
