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
import br.upe.sistemas.sisrep.sisrep.api.vos.InstituicaoVO;
import br.upe.sistemas.sisrep.sisrep.core.instituicao.Instituicao;
import br.upe.sistemas.sisrep.sisrep.core.instituicao.InstituicaoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class IesAPI {

  private final InstituicaoServico iesServico;

  @GetMapping("/instituicoes")
  public ResponseEntity<List<InstituicaoVO>> listarInstituicoes() {
    return ResponseEntity
        .ok(iesServico.listar().stream().map((e) -> convertToVO(e)).collect(Collectors.toList()));
  }

  @PostMapping("/instituicao")
  public ResponseEntity<InstituicaoVO> incluirInstituicao(@RequestBody InstituicaoVO iesVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/instituicao").toUriString());

    Instituicao ies = convertToModel(iesVo);
    InstituicaoVO vo = convertToVO(iesServico.incluir(ies));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar instituição

  @DeleteMapping("/instituicao/{id}")
  public void excluirInstituicao(@PathVariable Long id) {
    iesServico.excluir(id);
  }

  private InstituicaoVO convertToVO(Instituicao ies) {
    InstituicaoVO vo =
        InstituicaoVO.builder().id(ies.getId()).nome(ies.getNome()).cidade(ies.getCidade())
            .estado(ies.getEstado()).codigoMEC(ies.getCodigoMec()).cursos(ies.getCursos()).build();

    return vo;
  }

  private Instituicao convertToModel(InstituicaoVO vo) {
    return Instituicao.builder().id(vo.getId()).nome(vo.getNome()).cidade(vo.getCidade())
        .estado(vo.getEstado()).codigoMec(vo.getCodigoMEC()).cursos(vo.getCursos()).build();
  }

}
