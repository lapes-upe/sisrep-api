package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa;

import java.util.List;

public interface IFichaDispensaServico {

  List<FichaDispensa> listar();

  FichaDispensa incluir(FichaDispensa fichaDispensa);

  FichaDispensa alterar(FichaDispensa fichaDispensa);

  void excluir(Long id);
}
