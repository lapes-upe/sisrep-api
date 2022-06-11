package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);
}
