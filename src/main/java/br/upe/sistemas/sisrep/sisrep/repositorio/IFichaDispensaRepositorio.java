package br.upe.sistemas.sisrep.sisrep.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import br.upe.sistemas.sisrep.sisrep.modelo.FichaDispensa;

public interface IFichaDispensaRepositorio extends JpaRepository<FichaDispensa, Long> {
  List<FichaDispensa> findByUsuario(Usuario usuario);
}
