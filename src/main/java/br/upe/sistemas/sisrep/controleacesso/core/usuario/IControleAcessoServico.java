package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import br.upe.sistemas.sisrep.controleacesso.api.vos.ControleAcessoVO;

import java.security.Principal;
import java.util.List;

public interface IControleAcessoServico {

  Usuario incluir(Usuario usuario);

  Usuario alterar(Usuario usuario);

  void excluirUsuario(Long id);

  Usuario buscarUsuarioPorEmail(String email);

  List<Usuario> listarUsuarios();

  Usuario adicionarPerfilAoUsuario(String email, String perfil);

  Perfil incluir(Perfil perfil);

  Perfil alterar(Perfil perfil);

  void excluirPerfil(Long id);

  List<Perfil> listarPerfis();

  ControleAcessoVO entrarNoSistema(Principal principal);
}
