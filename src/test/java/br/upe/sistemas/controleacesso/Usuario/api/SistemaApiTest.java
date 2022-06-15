package br.upe.sistemas.controleacesso.Usuario.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.upe.sistemas.sisrep.SisRepApplication;
import br.upe.sistemas.sisrep.controleacesso.api.vos.EmailVO;

@SpringBootTest(classes = SisRepApplication.class)
@AutoConfigureMockMvc
public class SistemaApiTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void deveRetornarFound_QuandoListarServicos() throws Exception {
    mockMvc.perform(get("/api/sistemas/servicos")).andExpect(status().is3xxRedirection());
  }

  @Test
  public void deveRetornarFound_QuandoListarPerfis() throws Exception {
    EmailVO email = new EmailVO();
    email.setEmail("aluno@upe.br");
    mockMvc
        .perform(get("/api/sistemas/perfis").contentType("application/json")
            .content(objectMapper.writeValueAsString(email)))
        .andExpect(status().is3xxRedirection());
  }
}
