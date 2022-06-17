package br.upe.sistemas.sisrep.sisrep.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.upe.sistemas.sisrep.sisrep.modelo.InstituicaoEnsino;

public interface IInstituicaoEnsinoRepositorio extends JpaRepository<InstituicaoEnsino, Long> {

}
