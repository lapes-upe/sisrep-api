package br.upe.sistemas.sisrep.sisrep.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.upe.sistemas.sisrep.sisrep.modelo.Disciplina;

public interface IDisciplinaRepositorio extends JpaRepository<Disciplina, Long> {

}
