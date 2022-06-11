package br.upe.sistemas.sisrep.controleacesso.api;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.upe.sistemas.sisrep.controleacesso.api.vos.PerfilUsuarioVO;
import br.upe.sistemas.sisrep.controleacesso.api.vos.SistemaVO;
import br.upe.sistemas.sisrep.controleacesso.core.servicos.ISistemaServico;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.IControleAcessoServico;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sistemas")
@RequiredArgsConstructor
public class SistemaAPI {

  private final ISistemaServico ctrlSistema;
  private final IControleAcessoServico ctrlAcessoServico;

  @GetMapping("/servicos")
  public ResponseEntity<?> listarServicos() {
    ResponseEntity<List<SistemaVO>> retorno = null;

    List<SistemaVO> vos = ctrlSistema.listar().stream()
        .map(sistema -> SistemaVO.builder().id(sistema.getId()).descricao(sistema.getDescricao())
            .nome(sistema.getNome()).link(sistema.getLink()).icone(sistema.getIcone()).build())
        .collect(Collectors.toList());

    if (vos.isEmpty()) {
      retorno = ResponseEntity.noContent().build();
    } else {
      retorno = ResponseEntity.status(HttpStatus.FOUND).body(vos);
    }

    return retorno;
  }

  @GetMapping("/perfis")
  public ResponseEntity<?> listarPerfis(String email) {
    Usuario usuario = ctrlAcessoServico.buscarUsuario(email);
    ResponseEntity<List<PerfilUsuarioVO>> retorno = null;

    List<PerfilUsuarioVO> vos = usuario.getPerfis().stream().map(
        perfil -> PerfilUsuarioVO.builder().nome(perfil.getNome()).icone(perfil.getIcone()).build())
        .collect(Collectors.toList());

    if (vos.isEmpty()) {
      retorno = ResponseEntity.noContent().build();
    } else {
      retorno = ResponseEntity.status(HttpStatus.FOUND).body(vos);
    }

    return retorno;
  }
}
