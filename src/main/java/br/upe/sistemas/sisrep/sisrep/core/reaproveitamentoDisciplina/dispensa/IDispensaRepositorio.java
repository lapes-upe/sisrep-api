package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDispensaRepositorio extends JpaRepository<Dispensa, Long> {
  // Optional<Dispensa> findByUsuario(Usuario usuario);
}
