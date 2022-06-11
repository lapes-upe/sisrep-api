package br.upe.sistemas.sisrep.controleacesso.core.perfis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerfilRepositorio extends JpaRepository<Perfil, Long> {
	
}
