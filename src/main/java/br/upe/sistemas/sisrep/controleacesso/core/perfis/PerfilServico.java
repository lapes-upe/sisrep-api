package br.upe.sistemas.sisrep.controleacesso.core.perfis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.upe.sistemas.sisrep.controleacesso.core.usuario.IUsuarioRepositorio;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.TipoUsuario;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

public class PerfilServico implements IPerfilServico {
	
	@Autowired
	private IPerfilRepositorio perfilRepositorio;
	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<Perfil> listarPerfisDoUsuario(String email) {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		List<Perfil> perfis = new ArrayList<Perfil>();
		
		for (Perfil perfil : perfilRepositorio.findAll()) {
			for (TipoUsuario tipoUsuario : usuario.getPerfis()) {
				if (perfil.getNome() == tipoUsuario.getNome() ) {
					perfis.add(perfil);
				}
			}
		}
		
		return perfis;
	}

}
