package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import java.util.List;

public interface ISistemaServico {

  Sistema incluir(Sistema sistema);

  Sistema alterar(Sistema sistema);

  void excluir(Long id);

  List<Sistema> listar();
}
