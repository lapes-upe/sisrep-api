package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilRepositorio extends JpaRepository<Perfil, Long> {
    Perfil findByNome(String nome);
}
