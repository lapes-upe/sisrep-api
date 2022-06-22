package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

@Service
public class FichaDispensaServico implements IFichaDispensaServico {

  @Autowired
  IFichaDispensaRepositorio fichaDispensaRepositorio;

  @Override
  public List<FichaDispensa> listar() {
    return (List<FichaDispensa>) fichaDispensaRepositorio.findAll();
  }

  @Override
  public FichaDispensa incluir(FichaDispensa fichaDispensa) {
    validarInclusaoFichaDispensa(fichaDispensa);
    return fichaDispensaRepositorio.save(fichaDispensa);
  }

  @Override
  public FichaDispensa alterar(FichaDispensa fichaDispensa) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(Long id) {
    validarExclusaoFichaDispensa(id);
    fichaDispensaRepositorio.deleteById(id);
  }

  private void validarInclusaoFichaDispensa(FichaDispensa ficha) {
    if (ficha == null) {
      throw new SisrepException("Dados nulos");
    }

  }

  private void validarExclusaoFichaDispensa(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir ficha de dispensa: Informe o identificador correto");
    }

    if (!fichaDispensaRepositorio.existsById(id)) {
      throw new NaoEncontradoException(
          "Ocorreu um erro ao excluir ficha de dispensa: ficha de dispensa não encontrada");
    }
  }



}
