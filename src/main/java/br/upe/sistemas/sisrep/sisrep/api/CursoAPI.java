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
import br.upe.sistemas.sisrep.sisrep.api.envelope.CursoEnvelope;
import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import br.upe.sistemas.sisrep.sisrep.core.curso.CursoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class CursoAPI {

  private final CursoServico cursoServico;

  @GetMapping("/cursos")
  public ResponseEntity<List<CursoEnvelope>> listarCursos() {
    return ResponseEntity
        .ok(cursoServico.listar().stream().map((e) -> convertToVO(e)).collect(Collectors.toList()));
  }

  @PostMapping("/curso")
  public ResponseEntity<CursoEnvelope> incluirCurso(@RequestBody CursoEnvelope cursoVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/curso").toUriString());

    Curso curso = convertToModel(cursoVo);
    CursoEnvelope vo = convertToVO(cursoServico.incluir(curso));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar curso

  @DeleteMapping("/curso/{id}")
  public void excluirCurso(@PathVariable Long id) {
    cursoServico.excluir(id);
  }

  private CursoEnvelope convertToVO(Curso curso) {
    CursoEnvelope vo = CursoEnvelope.builder().id(curso.getId()).nome(curso.getNome())
        .instituicao(curso.getInstituicao()).malhas(curso.getMalhas()).build();

    return vo;
  }

  private Curso convertToModel(CursoEnvelope vo) {
    return Curso.builder().id(vo.getId()).nome(vo.getNome()).instituicao(vo.getInstituicao())
        .malhas(vo.getMalhas()).build();
  }
}
