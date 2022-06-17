package br.upe.sistemas.sisrep.sisrep.core.curso;

import java.util.List;

public interface ICursoServico {

  List<Curso> listar();

  Curso incluir();

  Curso alterar(Curso curso);

  void excluir(Long id);
}
