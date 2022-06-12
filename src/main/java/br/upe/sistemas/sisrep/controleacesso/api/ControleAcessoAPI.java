package br.upe.sistemas.sisrep.controleacesso.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.upe.sistemas.sisrep.controleacesso.api.vos.AssociarPerfilVO;
import br.upe.sistemas.sisrep.controleacesso.api.vos.DadosUsuarioVO;
import br.upe.sistemas.sisrep.controleacesso.api.vos.PerfilVO;
import br.upe.sistemas.sisrep.controleacesso.api.vos.UsuarioVO;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.IControleAcessoServico;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Perfil;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/controleacesso")
@RequiredArgsConstructor
public class ControleAcessoAPI {

  private final IControleAcessoServico ctrlAcessoServico;

  @GetMapping("/usuarios")
  public ResponseEntity<List<UsuarioVO>> listarUsuarios() {
    return ResponseEntity.ok(ctrlAcessoServico.listarUsuarios().stream().map(e -> convert(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/usuario")
  public ResponseEntity<UsuarioVO> incluir(@Valid @RequestBody UsuarioVO usuarioVO) {

    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/controleacesso/usuario").toUriString());

    Usuario usuario = convert(usuarioVO);
    UsuarioVO vo = convert(ctrlAcessoServico.incluir(usuario));

    return ResponseEntity.created(uri).body(vo);
  }

  @PutMapping("/usuario/{id}")
  public ResponseEntity<UsuarioVO> alterar(@PathVariable Long id,
      @Valid @RequestBody UsuarioVO usuarioVO) {

    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/controleacesso/usuario").toUriString());

    Usuario usuario = convert(usuarioVO);
    usuario.setId(id);

    UsuarioVO vo = convert(ctrlAcessoServico.alterar(usuario));

    return ResponseEntity.created(uri).body(vo);
  }

  @DeleteMapping("/usuario/{id}")
  public void excluirUsuario(@PathVariable Long id) {
    ctrlAcessoServico.excluirUsuario(id);
  }

  @PostMapping("/perfil")
  public ResponseEntity<PerfilVO> incluir(@Valid @RequestBody PerfilVO perfilVO) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/controleacesso/perfil").toUriString());

    Perfil perfil = convert(perfilVO);
    PerfilVO vo = convert(ctrlAcessoServico.incluir(perfil));

    return ResponseEntity.created(uri).body(vo);
  }

  @PutMapping("/perfil/{id}")
  public ResponseEntity<PerfilVO> alterar(@PathVariable Long id,
      @Valid @RequestBody PerfilVO perfilVO) {

    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/controleacesso/perfil").toUriString());

    Perfil perfil = convert(perfilVO);
    perfil.setId(id);

    PerfilVO vo = convert(ctrlAcessoServico.alterar(perfil));

    return ResponseEntity.created(uri).body(vo);
  }

  @DeleteMapping("/perfil/{id}")
  public void excluirPerfil(@PathVariable Long id) {
    ctrlAcessoServico.excluirPerfil(id);
  }

  @GetMapping("/perfis")
  public ResponseEntity<List<PerfilVO>> listarPerfis() {
    return ResponseEntity.ok(ctrlAcessoServico.listarPerfis().stream().map(e -> convert(e))
        .collect(Collectors.toList()));
  }

  @PostMapping("/perfil/associar")
  public ResponseEntity<UsuarioVO> adicionarPerfilUsuario(@Valid @RequestBody AssociarPerfilVO vo) {
    Usuario usuario = ctrlAcessoServico.adicionarPerfilAoUsuario(vo.getEmail(), vo.getPerfil());

    return ResponseEntity.ok().body(convert(usuario));
  }

  @GetMapping("/obterDadosUsuario")
  public ResponseEntity<DadosUsuarioVO> obterDadosUsuario(String email) {
    Usuario usuario = ctrlAcessoServico.buscarUsuarioPorEmail(email);

    DadosUsuarioVO vo = DadosUsuarioVO.builder().foto(usuario.getFoto()).email(usuario.getEmail())
        .nome(usuario.getNome()).endereco(usuario.getEndereco()).cidade(usuario.getCidade())
        .cep(usuario.getCep()).celular(usuario.getCelular()).build();

    return ResponseEntity.status(HttpStatus.FOUND).body(vo);
  }

  private Usuario convert(UsuarioVO vo) {

    Usuario usuario = Usuario.builder().id(vo.getId()).nome(vo.getNome()).email(vo.getEmail())
        .cpf(vo.getCpf()).token(vo.getToken()).ativo(vo.getAtivo()).build();

    if (vo.getPerfis() != null && !vo.getPerfis().isEmpty()) {
      usuario.setPerfis(new ArrayList<>());

      vo.getPerfis().stream().forEach(
          p -> usuario.getPerfis().add(Perfil.builder().id(p.getId()).nome(p.getNome()).build()));
    }

    return usuario;
  }

  private UsuarioVO convert(Usuario entidade) {

    UsuarioVO usuario =
        UsuarioVO.builder().id(entidade.getId()).nome(entidade.getNome()).email(entidade.getEmail())
            .cpf(entidade.getCpf()).token(entidade.getToken()).ativo(entidade.getAtivo()).build();

    if (entidade.getPerfis() != null && !entidade.getPerfis().isEmpty()) {
      usuario.setPerfis(new ArrayList<>());

      entidade.getPerfis().stream().forEach(
          p -> usuario.getPerfis().add(PerfilVO.builder().id(p.getId()).nome(p.getNome()).build()));
    }

    return usuario;
  }

  private Perfil convert(PerfilVO vo) {
    return Perfil.builder().id(vo.getId()).nome(vo.getNome()).icone(vo.getIcone()).build();
  }

  private PerfilVO convert(Perfil entidade) {
    return PerfilVO.builder().id(entidade.getId()).nome(entidade.getNome())
        .icone(entidade.getIcone()).build();
  }
}
