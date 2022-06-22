package br.upe.sistemas.sisrep.sisrep.core.instituicao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

@Service
public class InstituicaoServico implements IInstituicaoServico {

  @Autowired
  private IInstituicaoRepositorio iesRepositorio;

  @Override
  public List<Instituicao> listar() {
    return (List<Instituicao>) iesRepositorio.findAll();
  }

  @Override
  public Instituicao incluir(Instituicao ies) {
    validarInclusaoIes(ies);
    return iesRepositorio.save(ies);
  }

  @Override
  public Instituicao alterar(Instituicao ies) {
    return null;
  }

  @Override
  public void excluir(long id) {
    validarExclusaoIes(id);
    iesRepositorio.deleteById(id);

  }

  private void validarInclusaoIes(Instituicao ies) {
    if (ies == null) {
      throw new SisrepException("Dados nulos");
    }

    if (iesRepositorio.findByNome(ies.getNome()).isPresent()) {
      throw new SisrepException(
          "Ocorreu um erro ao incluir o usuário: já existe uma instituição de ensino cadastrada com esse nome"
              + ies.getNome());
    }
  }

  private void validarExclusaoIes(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir instituição de ensino: Informe o identificador correto");
    }

    if (!iesRepositorio.existsById(id)) {
      throw new NaoEncontradoException(
          "Ocorreu um erro ao excluir instituição de ensino: instituição de ensino não encontrada");
    }
  }

}
