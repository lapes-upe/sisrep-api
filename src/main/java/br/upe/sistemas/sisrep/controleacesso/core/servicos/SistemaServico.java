package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaServico implements ISistemaServico{

	@Autowired
	private ISistemaRepositorio repositorio;
	
	@Override
	public List<Sistema> listar() {
		return repositorio.findAll();
	}

}
