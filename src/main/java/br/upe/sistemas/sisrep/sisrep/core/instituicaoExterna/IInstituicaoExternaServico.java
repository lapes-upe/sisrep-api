package br.upe.sistemas.sisrep.sisrep.core.instituicaoExterna;

import java.util.List;

public interface IInstituicaoExternaServico {

  List<InstituicaoExterna> listar();

  InstituicaoExterna incluir(InstituicaoExterna ies);

  InstituicaoExterna alterar(InstituicaoExterna ies);

  void excluir(long id);

}
