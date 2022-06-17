package br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInstituicaoEnsinoRepositorio extends JpaRepository<InstituicaoEnsino, Long> {
  Optional<InstituicaoEnsino> findByNome(String nome);

}
