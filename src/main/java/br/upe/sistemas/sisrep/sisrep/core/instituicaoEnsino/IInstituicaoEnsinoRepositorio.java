package br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstituicaoEnsinoRepositorio extends JpaRepository<InstituicaoEnsino, Long> {
  InstituicaoEnsino findByNome(String nome);
}
