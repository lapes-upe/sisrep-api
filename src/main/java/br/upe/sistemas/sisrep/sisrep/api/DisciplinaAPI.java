package br.upe.sistemas.sisrep.sisrep.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.upe.sistemas.sisrep.sisrep.api.vos.DisciplinaVO;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.DisciplinaServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class DisciplinaAPI {

  private DisciplinaServico disciplinaServico;

  @GetMapping("/disciplinas")
  public ResponseEntity<List<DisciplinaVO>> listarDisciplinas() {
    return ResponseEntity.ok(disciplinaServico.listar().stream().map((e) -> convertToVO(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/disciplina")
  public ResponseEntity<DisciplinaVO> incluirDisciplina(@RequestBody DisciplinaVO disciplinaVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/disciplina").toUriString());

    Disciplina disciplina = convertToModel(disciplinaVo);
    DisciplinaVO vo = convertToVO(disciplinaServico.incluir(disciplina));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar disciplina

  @DeleteMapping("/disciplina/{id}")
  public void excluirDisciplina(Long id) {
    disciplinaServico.excluir(id);
  }

  public DisciplinaVO convertToVO(Disciplina disciplina) {
    DisciplinaVO vo = DisciplinaVO.builder().id(disciplina.getId()).nome(disciplina.getNome())
        .cargaHoraria(disciplina.getCargaHoraria()).media(disciplina.getMedia())
        .curso(disciplina.getCurso()).build();

    return vo;
  }

  private Disciplina convertToModel(DisciplinaVO vo) {
    return Disciplina.builder().id(vo.getId()).nome(vo.getNome()).cargaHoraria(vo.getCargaHoraria())
        .media(vo.getMedia()).curso(vo.getCurso()).build();
  }

}
