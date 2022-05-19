package br.upe.sistemas.sisrep.controleacesso.api;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.upe.sistemas.sisrep.controleacesso.core.IControleAcessoServico;
import br.upe.sistemas.sisrep.controleacesso.core.Perfil;
import br.upe.sistemas.sisrep.controleacesso.core.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/controleacesso")
@RequiredArgsConstructor
public class ControleAcessoAPI {

    private final IControleAcessoServico ctrlAcessoServico;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(ctrlAcessoServico.listarUsuarios());
    }

    @PostMapping("/usuario/salvar")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/controleacesso/usuario/salvar").toUriString());

        return ResponseEntity.created(uri).body(ctrlAcessoServico.salvarUsuario(usuario));
    }

    @PostMapping("/perfil/salvar")
    public ResponseEntity<Perfil> salvarPerfil(@RequestBody Perfil perfil) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/controleacesso/perfil/salvar").toUriString());

        return ResponseEntity.created(uri).body(ctrlAcessoServico.salvarPerfil(perfil));
    }

    @PostMapping("/perfil/adicionarUsuario")
    public ResponseEntity<?> adicionarPerfilAUsuario(@RequestBody AdicionarPerfilVO vo) {
        ctrlAcessoServico.adicionarPerfilAoUsuario(vo.getEmail(), vo.getPerfil());

        return ResponseEntity.ok().build();
    }
}
