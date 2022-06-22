package br.upe.sistemas.sisrep.sisrep.core.dispensa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

@Repository
public interface DispensaRepositorio extends JpaRepository<Dispensa, Long> {
  Optional<Dispensa> findByUsuario(Usuario usuario);
}
