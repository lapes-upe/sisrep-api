package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa;

import java.util.List;

public interface IDispensaServico {

  List<Dispensa> listar();

  Dispensa incluir(Dispensa dispensa);

  Dispensa alterar(Dispensa dispensa);

  void excluir(long id);
}
