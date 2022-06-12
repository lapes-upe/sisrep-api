package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.upe.sistemas.sisrep.base.NaoEncontradoException;
import br.upe.sistemas.sisrep.base.ValidacaoUtil;
import br.upe.sistemas.sisrep.controleacesso.core.exception.ControleAcessoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@RequiredArgsConstructor
public class SistemaServico implements ISistemaServico {

  private final ISistemaRepositorio repositorio;

  @Override
  @Transactional(readOnly = false)
  public Sistema incluir(Sistema sistema) {
    log.debug("Salvando sistema {}", sistema);

    ValidacaoUtil.validar(sistema);

    if (this.repositorio.findByNomeIgnoreCase(sistema.getNome()) != null) {
      log.error("Já existe um sistema com o nome {}", sistema.getNome());
      throw new ControleAcessoException("Já existe um sistema com o nome " + sistema.getNome());
    }

    sistema.setId(null);

    return this.repositorio.save(sistema);
  }

  @Override
  @Transactional(readOnly = false)
  public Sistema alterar(Sistema sistema) {
    log.debug("Alterando sistema {}", sistema);

    ValidacaoUtil.validar(sistema);

    if (sistema.getId() == null || sistema.getId() <= 0) {
      log.error("O identificador do sistema não foi informado");
      throw new ControleAcessoException("Informe o identificador do sistema a ser alterado");
    }

    if (this.repositorio.findByNomeIgnoreCaseAndIdNot(sistema.getNome(), sistema.getId()) != null) {
      log.error("Já existe um outro sistema com o nome {}", sistema.getNome());
      throw new ControleAcessoException("Já existe um sistema com o nome " + sistema.getNome());
    }

    return this.repositorio.save(sistema);
  }

  @Override
  @Transactional(readOnly = false)
  public void excluir(Long id) {
    log.debug("Excluindo sistema {}", id);

    if (id == null || id <= 0) {
      log.error("O identificador do sistema não foi informado");
      throw new ControleAcessoException("Informe o identificador do sistema a ser excluído");
    }

    this.repositorio.deleteById(id);

    log.debug("Sistema {} excluido", id);
  }

  @Override
  public List<Sistema> listar() {
    List<Sistema> sistemas = repositorio.findAll();

    if (sistemas.isEmpty()) {
      throw new NaoEncontradoException("Não existem sistemas cadastrados");
    }

    log.debug("Encontrados {} sistemas(s)", sistemas.size());

    return sistemas;
  }
}
