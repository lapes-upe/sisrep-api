package br.upe.sistemas.sisrep.sisrep.core.disciplina;

import java.util.List;

public interface IDisciplinaServico {

  List<Disciplina> listar();

  Disciplina incluir(Disciplina disciplina);
}
