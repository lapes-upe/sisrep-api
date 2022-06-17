package br.upe.sistemas.sisrep.sisrep.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.upe.sistemas.sisrep.sisrep.modelo.Curso;

public interface ICursoRepositorio extends JpaRepository<Curso, Long> {

}
