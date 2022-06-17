package br.upe.sistemas.sisrep.sisrep.core.curso;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

public class CursoServico implements ICursoServico {

  @Autowired
  private ICursoRepositorio cursoRepositorio;

  @Override
  public List<Curso> listar() {
    return (List<Curso>) cursoRepositorio.findAll();
  }

  @Override
  public Curso incluir(Curso curso) {
    validarInclusaoCurso(curso);
    return cursoRepositorio.save(curso);
  }

  @Override
  public Curso alterar(Curso curso) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(Long id) {
    validarExclusaoUsuario(id);
    cursoRepositorio.deleteById(id);
  }

  public void validarInclusaoCurso(Curso curso) {
    if (curso == null) {
      throw new SisrepException("Dados nulos");
    }

    if (cursoRepositorio.findByNome(curso.getNome()).isPresent()) {
      throw new SisrepException(
          "Ocorreu um erro ao incluir curso: já existe um curso cadastrado com esse nome.");
    }
  }

  public void validarExclusaoUsuario(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir curso: Informe o identificador correto");
    }

    if (!cursoRepositorio.existsById(id)) {
      throw new NaoEncontradoException("Ocorreu um erro ao excluir curso: curso não encontrado");
    }
  }

}
