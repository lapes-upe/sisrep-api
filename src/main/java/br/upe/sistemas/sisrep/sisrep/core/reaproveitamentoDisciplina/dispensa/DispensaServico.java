package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

@Service
public class DispensaServico implements IDispensaServico {

  @Autowired
  IDispensaRepositorio dispensaRepositorio;

  @Override
  public List<Dispensa> listar() {
    return (List<Dispensa>) dispensaRepositorio.findAll();
  }

  @Override
  public Dispensa incluir(Dispensa dispensa) {
    validarInclusaoDispensa(dispensa);
    return dispensaRepositorio.save(dispensa);
  }

  @Override
  public Dispensa alterar(Dispensa dispensa) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(long id) {
    validarExclusaoDispensa(id);
    dispensaRepositorio.deleteById(id);
  }

  private void validarInclusaoDispensa(Dispensa ficha) {
    if (ficha == null) {
      throw new SisrepException("Dados nulos");
    }

  }

  private void validarExclusaoDispensa(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir ficha de dispensa: Informe o identificador correto");
    }

    if (!dispensaRepositorio.existsById(id)) {
      throw new NaoEncontradoException(
          "Ocorreu um erro ao excluir ficha de dispensa: ficha de dispensa não encontrada");
    }
  }

}
