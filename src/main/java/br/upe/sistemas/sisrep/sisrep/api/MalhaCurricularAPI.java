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
import br.upe.sistemas.sisrep.sisrep.api.envelope.MalhaCurricularEnvelope;
import br.upe.sistemas.sisrep.sisrep.core.malhaCurricular.MalhaCurricular;
import br.upe.sistemas.sisrep.sisrep.core.malhaCurricular.MalhaCurricularServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class MalhaCurricularAPI {

  private MalhaCurricularServico malhaServico;

  @GetMapping("/malhas")
  public ResponseEntity<List<MalhaCurricularEnvelope>> listarInstituicoes() {
    return ResponseEntity.ok(malhaServico.listar().stream().map((e) -> convertToEnvelope(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/malha")
  public ResponseEntity<MalhaCurricularEnvelope> incluirInstituicao(
      @RequestBody MalhaCurricularEnvelope malhaEnvelope) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/mapa").toUriString());

    MalhaCurricular malha = convertToModel(malhaEnvelope);
    MalhaCurricularEnvelope envelope = convertToEnvelope(malhaServico.incluir(malha));

    return ResponseEntity.created(uri).body(envelope);
  }

  // Fazer método de alterar Malha curricular

  @DeleteMapping("/malha/{id}")
  public void excluirInstituicao(@PathVariable Long id) {
    malhaServico.excluir(id);
  }

  private MalhaCurricularEnvelope convertToEnvelope(MalhaCurricular malha) {
    MalhaCurricularEnvelope vo =
        MalhaCurricularEnvelope.builder().id(malha.getId()).codigo(malha.getCodigo())
            .anotImplantacao(malha.getAnoImplantacao()).parecerCEE(malha.getParecerCEE())
            .curso(malha.getCurso()).disciplinas(malha.getDisciplinas()).build();

    return vo;
  }


  private MalhaCurricular convertToModel(MalhaCurricularEnvelope envelope) {
    return MalhaCurricular.builder().id(envelope.getId()).codigo(envelope.getCodigo())
        .anoImplantacao(envelope.getAnotImplantacao()).parecerCEE(envelope.getParecerCEE())
        .curso(envelope.getCurso()).disciplinas(envelope.getDisciplinas()).build();
  }
}
