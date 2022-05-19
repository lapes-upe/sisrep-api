package br.upe.sistemas.sisrep.controleacesso.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByNome(String nome);
}
