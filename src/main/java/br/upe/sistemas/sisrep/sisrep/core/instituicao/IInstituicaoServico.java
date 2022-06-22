package br.upe.sistemas.sisrep.sisrep.core.instituicao;

import java.util.List;

public interface IInstituicaoServico {

  List<Instituicao> listar();

  Instituicao incluir(Instituicao ies);

  Instituicao alterar(Instituicao ies);

  void excluir(long id);

}
