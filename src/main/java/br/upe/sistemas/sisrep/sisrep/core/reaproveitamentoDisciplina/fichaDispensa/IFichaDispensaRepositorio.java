package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

@Repository
public interface IFichaDispensaRepositorio extends JpaRepository<FichaDispensa, Long> {
  Optional<List<FichaDispensa>> findByRequerente(Usuario requerente);
}
