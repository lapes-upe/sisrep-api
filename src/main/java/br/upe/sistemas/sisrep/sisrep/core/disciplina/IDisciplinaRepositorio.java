package br.upe.sistemas.sisrep.sisrep.core.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplinaRepositorio extends JpaRepository<Disciplina, Long> {
  Disciplina findById(long id);
}