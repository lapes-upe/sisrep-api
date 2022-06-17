package br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino;

import java.util.List;

public interface IInstituicaoEnsinoServico {

  List<InstituicaoEnsino> listar();

  InstituicaoEnsino incluir(InstituicaoEnsino ies);

  InstituicaoEnsino alterar(InstituicaoEnsino ies);

  void excluir(long id);

}
