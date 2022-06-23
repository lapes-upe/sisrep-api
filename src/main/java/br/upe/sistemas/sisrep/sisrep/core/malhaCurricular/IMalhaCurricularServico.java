package br.upe.sistemas.sisrep.sisrep.core.malhaCurricular;

import java.util.List;

public interface IMalhaCurricularServico {

  List<MalhaCurricular> listar();

  MalhaCurricular incluir(MalhaCurricular malha);

  MalhaCurricular alterar(MalhaCurricular malha);

  void excluir(Long id);
}
