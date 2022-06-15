package br.upe.sistemas.controleacesso.api.controleAcesso;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.upe.sistemas.sisrep.SisRepApplication;
import br.upe.sistemas.sisrep.controleacesso.api.vos.AssociarPerfilVO;
import br.upe.sistemas.sisrep.controleacesso.api.vos.PerfilVO;

@SpringBootTest(classes = SisRepApplication.class)
@AutoConfigureMockMvc
public class PerfilApiTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  // TODO
  public void deveRetornarCreated_QuandoIncluirPerfil() throws Exception {
    PerfilVO perfil = PerfilVO.builder().nome("asdsa").icone(null).build();

    mockMvc.perform(post("/api/controleacesso/perfil").contentType("application/json")
        .content(objectMapper.writeValueAsString(perfil))).andExpect(status().isOk());
  }

  public void deveRetornarSucesso_QuandoAlterarPerfil() {
    // TODO
  }

  public void deveRetornarSucesso_QuandoExcluirPerfil() {
    // TODO
  }

  @Test
  public void deveRetornarSucesso_QuandoListarPerfis() throws Exception {
    mockMvc.perform(get("/api/controleacesso/perfis")).andExpect(status().isOk());
  }

  // TODO
  public void deveRetornarSucesso_QuandoAdicionarPerfilAUsuario() throws Exception {
    AssociarPerfilVO associarPerfil =
        AssociarPerfilVO.builder().email("aluno@upe.br").perfil("teste").build();

    mockMvc.perform(post("/api/controleacesso/perfil/associar").contentType("application/json")
        .content(objectMapper.writeValueAsString(associarPerfil))).andExpect(status().isOk());
  }
}
