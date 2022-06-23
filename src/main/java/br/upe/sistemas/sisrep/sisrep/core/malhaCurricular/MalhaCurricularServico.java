package br.upe.sistemas.sisrep.sisrep.core.malhaCurricular;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.sistemas.sisrep.sisrep.excecao.NaoEncontradoException;
import br.upe.sistemas.sisrep.sisrep.excecao.SisrepException;

@Service
public class MalhaCurricularServico implements IMalhaCurricularServico {

  @Autowired
  private IMalhaCurricularRepositorio malhaRepositorio;

  @Override
  public List<MalhaCurricular> listar() {
    return (List<MalhaCurricular>) malhaRepositorio.findAll();
  }

  @Override
  public MalhaCurricular incluir(MalhaCurricular malha) {
    validarInclusaoMalha(malha);
    return malhaRepositorio.save(malha);
  }

  @Override
  public MalhaCurricular alterar(MalhaCurricular malha) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void excluir(Long id) {
    validarExclusaoMalha(id);
    malhaRepositorio.deleteById(id);
  }

  private void validarInclusaoMalha(MalhaCurricular malha) {
    if (malha == null) {
      throw new SisrepException("Dados nulos");
    }

    if (malhaRepositorio.findByCodigo(malha.getCodigo()).isPresent()) {
      throw new SisrepException(
          "Ocorreu um erro ao incluir o usuário: já existe uma instituição de ensino cadastrada com esse nome"
              + malha.getCodigo());
    }
  }

  private void validarExclusaoMalha(Long id) {
    if (id == null) {
      throw new SisrepException(
          "Ocorreu um erro ao excluir instituição de ensino: Informe o identificador correto");
    }

    if (!malhaRepositorio.existsById(id)) {
      throw new NaoEncontradoException(
          "Ocorreu um erro ao excluir instituição de ensino: instituição de ensino não encontrada");
    }
  }

}
