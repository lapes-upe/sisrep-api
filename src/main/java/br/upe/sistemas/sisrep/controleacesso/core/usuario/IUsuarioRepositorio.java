package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

  Usuario findByNomeIgnoreCase(String nome);

  Usuario findByEmailIgnoreCase(String email);

  Usuario findByEmailIgnoreCaseAndIdNot(String email, Long id);
}
