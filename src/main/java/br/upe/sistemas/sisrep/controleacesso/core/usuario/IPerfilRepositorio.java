package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilRepositorio extends JpaRepository<TipoUsuario, Long> {
    TipoUsuario findByNome(String nome);
}
