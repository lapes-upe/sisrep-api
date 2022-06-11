package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import java.util.List;

public interface IControleAcessoServico {
    Usuario salvarUsuario(Usuario usuario);

    TipoUsuario salvarPerfil(TipoUsuario tipoUsuario);

    void adicionarPerfilAoUsuario(String email, String perfil);

    Usuario buscarUsuario(String email);

    List<Usuario> listarUsuarios();
}
