package br.upe.sistemas.sisrep.controleacesso.core.perfis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.upe.sistemas.sisrep.controleacesso.core.usuario.IUsuarioRepositorio;

public class PerfilServico implements IPerfilServico {
	
	@Autowired
	private IPerfilRepositorio perfilRepositorio;
	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<Perfil> listar(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
