package br.upe.sistemas.sisrep.sisrep.core.instituicaoExterna;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstituicaoExternaRepositorio extends JpaRepository<InstituicaoExterna, Long> {
  Optional<InstituicaoExterna> findByNome(String nome);

}
