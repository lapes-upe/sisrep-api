package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import br.upe.sistemas.sisrep.base.NaoEncontradoException;
import br.upe.sistemas.sisrep.base.ValidacaoUtil;
import br.upe.sistemas.sisrep.controleacesso.core.exception.ControleAcessoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
@RequiredArgsConstructor
public class ControleAcessoServico implements IControleAcessoServico, UserDetailsService {

  private final IUsuarioRepositorio usuarioRepo;
  private final IPerfilRepositorio perfilRepo;
  private final PasswordEncoder encoder;

  @Override
  @Transactional(readOnly = false)
  public Perfil incluir(Perfil perfil) {
    log.debug("Salvando perfil {}", perfil);

    ValidacaoUtil.validar(perfil);

    if (this.perfilRepo.findByNomeIgnoreCase(perfil.getNome()) != null) {
      log.error("Já existe um perfil com o nome {}", perfil.getNome());
      throw new ControleAcessoException("Já existe um perfil com o nome " + perfil.getNome());
    }

    perfil.setId(null);

    return this.perfilRepo.save(perfil);
  }

  @Override
  @Transactional(readOnly = false)
  public Perfil alterar(Perfil perfil) {
    log.debug("Alterando perfil {}", perfil);

    ValidacaoUtil.validar(perfil);

    if (perfil.getId() == null || perfil.getId() <= 0) {
      log.error("O identificador do perfil não foi informado");
      throw new ControleAcessoException("Informe o identificador do perfil a ser alterado");
    }

    if (this.perfilRepo.findByNomeIgnoreCaseAndIdNot(perfil.getNome(), perfil.getId()) != null) {
      log.error("Já existe um outro perfil com o nome {}", perfil.getNome());
      throw new ControleAcessoException("Já existe um perfil com o nome " + perfil.getNome());
    }

    return this.perfilRepo.save(perfil);
  }

  @Override
  @Transactional(readOnly = false)
  public void excluirPerfil(Long id) {
    log.debug("Excluindo perfil {}", id);

    if (id == null || id <= 0) {
      log.error("O identificador do perfil não foi informado");
      throw new ControleAcessoException("Informe o identificador do perfil a ser excluído");
    }

    this.perfilRepo.deleteById(id);

    log.debug("Perfil {} excluido", id);
  }

  @Override
  public List<Perfil> listarPerfis() {
    log.debug("Recuperando a lista de todos os perfis cadastrados");

    List<Perfil> perfis = this.perfilRepo.findAll(Sort.by("nome").ascending());

    if (perfis.isEmpty()) {
      log.error("Não existem perfis cadastados no sistema");
      throw new NaoEncontradoException("Não existem perfis cadastrados no sistema.");
    }

    log.trace("Encontrados {} perfil(is)", perfis.size());

    return perfis;

  }

  @Override
  @Transactional(readOnly = false)
  public Usuario incluir(Usuario usuario) {
    log.debug("Salvando usuario {}", usuario);

    ValidacaoUtil.validar(usuario);

    if (this.usuarioRepo.findByEmailIgnoreCase(usuario.getEmail()) != null) {
      log.error("Já existe um usuario com o email {}", usuario.getEmail());
      throw new ControleAcessoException("Já existe um usuario com o email " + usuario.getEmail());
    }

    usuario.setId(null);

    log.trace("Codificando a senha do usuario");

    usuario.setToken(encoder.encode(usuario.getToken()));

    return this.usuarioRepo.save(usuario);
  }

  @Override
  @Transactional(readOnly = false)
  public Usuario alterar(Usuario perfil) {
    log.debug("Alterando usuario {}", perfil);

    ValidacaoUtil.validar(perfil);

    if (perfil.getId() == null || perfil.getId() <= 0) {
      log.error("O identificador do usuario não foi informado");
      throw new ControleAcessoException("Informe o identificador do usuario a ser alterado");
    }

    if (this.usuarioRepo.findByEmailIgnoreCaseAndIdNot(perfil.getEmail(), perfil.getId()) != null) {
      log.error("Já existe um outro usuario com o email {}", perfil.getEmail());
      throw new ControleAcessoException("Já existe um usuario com o email " + perfil.getEmail());
    }

    return this.usuarioRepo.save(perfil);
  }


  @Override
  @Transactional(readOnly = false)
  public void excluirUsuario(Long id) {
    log.debug("Excluindo usuario {}", id);

    if (id == null || id <= 0) {
      log.error("O identificador do usuario não foi informado");
      throw new ControleAcessoException("Informe o identificador do usuario a ser excluído");
    }

    this.usuarioRepo.deleteById(id);

    log.debug("Usuario {} excluido", id);
  }

  @Override
  public Usuario buscarUsuarioPorEmail(String email) {
    log.debug("Buscando usuario por email {}", email);

    ValidacaoUtil.valida(email, "Informe o email do usuário");

    Usuario usuario = this.usuarioRepo.findByEmailIgnoreCase(email);

    if (usuario == null) {
      log.error("Não existe usuário cadastado no sistema com o email {}", email);
      throw new NaoEncontradoException("Usuário não encontrado");
    }

    log.trace("Encontrado o usuario {}", usuario);

    return usuario;
  }

  @Override
  public List<Usuario> listarUsuarios() {
    log.debug("Recuperando a lista de todos os usuarios cadastrados");

    List<Usuario> usuarios = this.usuarioRepo.findAll(Sort.by("nome").ascending());

    if (usuarios.isEmpty()) {
      log.error("Não existem usuários cadastados no sistema");
      throw new NaoEncontradoException("Não existem usuários cadastrados no sistema.");
    }

    log.debug("Encontrados {} usuario(s)", usuarios.size());

    return usuarios;

  }

  @Override
  @Transactional(readOnly = false)
  public Usuario adicionarPerfilAoUsuario(String email, String nomePerfil) {
    log.debug("adicionando perfil:" + nomePerfil + " ao usuário:" + email);

    ValidacaoUtil.valida("Informe o email e o perfil a ser associado ao usuário", email, nomePerfil);


    email = StringUtils.trimWhitespace(email);
    Usuario usuario = this.usuarioRepo.findByEmailIgnoreCase(email);

    if (usuario == null || usuario.getId() == null) {
      log.error("Usuario com email {} não encontrado no sistema", email);
      throw new NaoEncontradoException("Usuário não encontrado no sistema:" + email);
    }

    nomePerfil = StringUtils.trimWhitespace(nomePerfil);
    Perfil perfil = this.perfilRepo.findByNomeIgnoreCase(nomePerfil);

    if (perfil == null || perfil.getId() == null) {
      log.error("Perfil {} não encontrado no sistema", perfil);
      throw new NaoEncontradoException("Perfil não encontrado no sistema:" + nomePerfil);
    }


    // verificar se o perfil nao ja esta associado ao usuario
    for (Perfil p : usuario.getPerfis()) {
      if (p.getNome().equalsIgnoreCase(nomePerfil)) {
        log.error("O usuário {0} já tem o Perfil {1} associado", email, perfil);
        throw new NaoEncontradoException("O usuário " + email + " já tem o perfil " + nomePerfil + " associado.");
      }
    }

    usuario.getPerfis().add(perfil);

    return this.usuarioRepo.save(usuario);
  }

  /**
   * Fornece ao Spring Security as permissões do usuário.
   */
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    ValidacaoUtil.valida(email, "Informe o email do usuário");

    Usuario usuario = this.usuarioRepo.findByEmailIgnoreCase(email);

    if (usuario == null || usuario.getId() == null) {
      log.error("Usuario com email {} não encontrado no sistema", email);
      throw new UsernameNotFoundException("Usuário não encontrado no sistema:" + email);
    }

    Collection<SimpleGrantedAuthority> permissoes = new ArrayList<SimpleGrantedAuthority>();

    usuario.getPerfis().forEach(perfil -> permissoes.add(new SimpleGrantedAuthority(perfil.getNome())));

    return new User(usuario.getEmail(), usuario.getToken(), permissoes);
  }


}

