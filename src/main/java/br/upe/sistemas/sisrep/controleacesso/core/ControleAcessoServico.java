package br.upe.sistemas.sisrep.controleacesso.core;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ControleAcessoServico implements IControleAcessoServico {

    private final IUsuarioRepositorio usuarioRepo;
    private final IPerfilRepositorio perfilRepo;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        log.debug("salvando usuario:" + usuario);

        // TODO: implementar RNs
        return this.usuarioRepo.save(usuario);
    }

    @Override
    public Perfil salvarPerfil(Perfil perfil) {
        log.debug("salvando perfil:" + perfil);

        // TODO: implementar RNs
        return this.perfilRepo.save(perfil);
    }

    @Override
    public void adicionarPerfilAoUsuario(String email, String nomePerfil) {
        log.debug("adicionando perfil:" + nomePerfil + " ao usuário:" + email);

        // TODO: implementar RNs
        Usuario usuario = this.usuarioRepo.findByNome(email);
        Perfil perfil = this.perfilRepo.findByNome(nomePerfil);
        usuario.getPerfis().add(perfil);
    }

    @Override
    public Usuario buscarUsuario(String email) {
        log.debug("buscando usuario:" + email);

        // TODO: implementar RNs

        return this.usuarioRepo.findByNome(email);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        log.debug("recuperando todos os usuarios");

        // TODO: implementar RNs

        return this.usuarioRepo.findAll();
    }

}
