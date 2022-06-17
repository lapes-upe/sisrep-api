package br.upe.sistemas.sisrep.sisrep.core.curso;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepositorio extends JpaRepository<Curso, Long> {
  Optional<Curso> findByNome(String nome);
}
