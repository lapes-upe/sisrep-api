package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilRepositorio extends JpaRepository<Perfil, Long> {

  Perfil findByNomeIgnoreCase(String nome);

  Perfil findByNomeIgnoreCaseAndIdNot(String nome, Long id);

}
