package br.upe.sistemas.sisrep.controleacesso.core.perfis;

import java.util.List;

public interface IPerfilServico {
  List<Perfil> listarPerfisDoUsuario(String email);
}
