package br.upe.sistemas.sisrep.sisrep.core.disciplina;

import java.util.List;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

public class DisciplinaServico implements IDisciplinaServico {

  private IDisciplinaRepositorio disciplinaRepositorio;

  @Override
  public List<Disciplina> listar() {
    return (List<Disciplina>) disciplinaRepositorio.findAll();
  }

  @Override
  public Disciplina incluir(Disciplina disciplina) {
    validarInclusaoDisciplina(disciplina);
    return disciplinaRepositorio.save(disciplina);
  }

  @Override
  public Disciplina alterar(Disciplina disciplina) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(long id) {
    validarExclusaoDisciplina(id);
    disciplinaRepositorio.deleteById(id);
  }

  private void validarInclusaoDisciplina(Disciplina disciplina) {
    if (disciplina == null) {
      throw new SisrepException("Dados nulos");
    }

    if (disciplinaRepositorio.findById(disciplina.getId()).isPresent()) {
      throw new SisrepException(
          "Ocorreu um erro ao incluir disciplina: já existe uma disciplina cadastrada com esse identificador");
    }
  }

  private void validarExclusaoDisciplina(long id) {
    if (id == 0L) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir curso: Informe o identificador correto");
    }

    if (!disciplinaRepositorio.existsById(id)) {
      throw new NaoEncontradoException("Ocorreu um erro ao excluir curso: curso não encontrado");
    }
  }

}
