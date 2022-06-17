package br.upe.sistemas.sisrep.sisrep.core.fichaDispensa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

public interface IFichaDispensaRepositorio extends JpaRepository<FichaDispensa, Long> {
  Optional<FichaDispensa> findByUsuario(Usuario usuario);
}
