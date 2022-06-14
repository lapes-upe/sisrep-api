package br.upe.sistemas.controleacesso.testesUnitarios;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.ControleAcessoServico;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.IPerfilRepositorio;

public class ControleAcessoUsuarioServico {

  @InjectMocks
  private ControleAcessoServico controleAcessoServico;

  @Mock
  private IPerfilRepositorio perfilRepositorio;


  @Before(value = "")
  public void setUp() throws Exception {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testeIncluirPerfilComSucesso() {

  }

  @Test
  public void testeAlterarIncluirPerfilComSucesso() {

  }

  @Test
  public void testeExcluirPerfilComSucesso() {

  }

  @Test
  public void testeListarPerfisComSucesso() {

  }

}
