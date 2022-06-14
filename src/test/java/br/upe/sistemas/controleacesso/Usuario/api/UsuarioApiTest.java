package br.upe.sistemas.controleacesso.Usuario.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.upe.sistemas.sisrep.SisRepApplication;
import br.upe.sistemas.sisrep.controleacesso.api.vos.EmailVO;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Perfil;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

@SpringBootTest(classes = SisRepApplication.class)
@AutoConfigureMockMvc
public class UsuarioApiTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void deveRetornarSucesso_QuandoListarUsuarios() throws Exception {
    mockMvc.perform(get("/api/controleacesso/usuarios")).andExpect(status().isOk());
  }

  // Não está funcionando(O problema tá nesse setFoto)
  public void deveRetornarSucesso_QuandoIncluirUsuario() throws Exception {
    Usuario usuario = new Usuario();

    List<Perfil> perfis = new ArrayList<Perfil>();

    usuario.setFoto(null).setEmail("teste@gmail.com").setNome("teste").setEndereco("endereco")
        .setCidade("cidade").setCep("cep").setCelular("celular").setCpf("13580169416")
        .setToken("token").setAtivo(true).setPerfis(perfis);

    mockMvc.perform(post("/api/controleacesso/usuario").contentType("application/json")
        .content(objectMapper.writeValueAsString(usuario))).andExpect(status().isOk());
  }

  public void deveRetornarSucesso_QuandoAlterarUsuario() throws Exception {

  }

  public void deveRetornarSucesso_QuandoExcluirUsuario() throws Exception {

  }

  @Test
  public void deveRetornarFound_QuandoObterDados() throws Exception {
    EmailVO email = new EmailVO();
    email.setEmail("aluno@upe.br");

    mockMvc
        .perform(get("/api/controleacesso/usuario/obterDados").contentType("application/json")
            .content(objectMapper.writeValueAsString(email)))
        .andExpect(status().is3xxRedirection());
  }

}
