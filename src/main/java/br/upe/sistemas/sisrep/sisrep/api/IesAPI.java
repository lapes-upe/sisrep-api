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
import br.upe.sistemas.sisrep.sisrep.api.vos.IesVO;
import br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino.InstituicaoEnsino;
import br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino.InstituicaoEnsinoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sisrep")
@RequiredArgsConstructor
public class IesAPI {

  private final InstituicaoEnsinoServico iesServico;

  @GetMapping("/instituicoes")
  public ResponseEntity<List<IesVO>> listarInstituicoes() {
    return ResponseEntity
        .ok(iesServico.listar().stream().map((e) -> convertToVO(e)).collect(Collectors.toList()));
  }

  @PostMapping("/instituicao")
  public ResponseEntity<IesVO> incluirInstituicao(@RequestBody IesVO iesVo) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/sisrep/ies/incluirIes").toUriString());

    InstituicaoEnsino ies = convertToModel(iesVo);
    IesVO vo = convertToVO(iesServico.incluir(ies));

    return ResponseEntity.created(uri).body(vo);
  }

  // Fazer método de alterar instituição

  @DeleteMapping("/instituicao/{id}")
  public void excluirInstituicao(@PathVariable Long id) {
    iesServico.excluir(id);
  }

  private IesVO convertToVO(InstituicaoEnsino ies) {
    IesVO vo = IesVO.builder().id(ies.getId()).nome(ies.getNome()).build();

    return vo;
  }

  private InstituicaoEnsino convertToModel(IesVO vo) {
    return InstituicaoEnsino.builder().id(vo.getId()).nome(vo.getNome()).build();
  }

}