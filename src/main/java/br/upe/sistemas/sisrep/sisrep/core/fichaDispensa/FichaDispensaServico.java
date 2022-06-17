package br.upe.sistemas.sisrep.sisrep.core.fichaDispensa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

public class FichaDispensaServico implements IFichaDispensaServico {

  @Autowired
  IFichaDispensaRepositorio fichaRepositorio;

  @Override
  public List<FichaDispensa> listar() {
    return (List<FichaDispensa>) fichaRepositorio.findAll();
  }

  @Override
  public FichaDispensa incluir(FichaDispensa fichaDispensa) {
    validarInclusaoFichaDispensa(fichaDispensa);
    return fichaRepositorio.save(fichaDispensa);
  }

  @Override
  public FichaDispensa alterar(FichaDispensa fichaDispensa) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(long id) {
    validarExclusaoFichaDispensa(id);
    fichaRepositorio.deleteById(id);
  }

  private void validarInclusaoFichaDispensa(FichaDispensa ficha) {
    if (ficha == null) {
      throw new SisrepException("Dados nulos");
    }

    if (fichaRepositorio.findByUsuario(ficha.getUsuario()).isPresent()) {
      throw new SisrepException(
          "Ocorreu um erro ao incluir ficha de dispensa: já existe uma ficha de dispensa cadastrada para esse usuário.");
    }
  }

  private void validarExclusaoFichaDispensa(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir ficha de dispensa: Informe o identificador correto");
    }

    if (!fichaRepositorio.existsById(id)) {
      throw new NaoEncontradoException(
          "Ocorreu um erro ao excluir ficha de dispensa: ficha de dispensa não encontrada");
    }
  }

}
