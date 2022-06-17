package br.upe.sistemas.sisrep.sisrep.core.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepositorio extends JpaRepository<Curso, Long> {
  Curso findByNome(String nome);
}
