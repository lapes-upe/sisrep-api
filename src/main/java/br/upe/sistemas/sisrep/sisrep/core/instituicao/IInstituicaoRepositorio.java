package br.upe.sistemas.sisrep.sisrep.core.instituicao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstituicaoRepositorio extends JpaRepository<Instituicao, Long> {
  Optional<Instituicao> findByNome(String nome);

}
