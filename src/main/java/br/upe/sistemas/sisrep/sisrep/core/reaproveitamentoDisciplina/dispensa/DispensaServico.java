package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

@Service
public class DispensaServico implements IDispensaServico {

  @Autowired
  IDispensaRepositorio fichaRepositorio;

  @Override
  public List<Dispensa> listar() {
    return (List<Dispensa>) fichaRepositorio.findAll();
  }

  @Override
  public Dispensa incluir(Dispensa dispensa) {
    validarInclusaoFichaDispensa(dispensa);
    return fichaRepositorio.save(dispensa);
  }

  @Override
  public Dispensa alterar(Dispensa dispensa) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(long id) {
    validarExclusaoFichaDispensa(id);
    fichaRepositorio.deleteById(id);
  }

  private void validarInclusaoFichaDispensa(Dispensa ficha) {
    if (ficha == null) {
      throw new SisrepException("Dados nulos");
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
