package br.upe.sistemas.sisrep.sisrep.core.malhaCurricular;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMalhaCurricularRepositorio extends JpaRepository<MalhaCurricular, Long> {
  List<MalhaCurricular> findByCodigo(String codigo);
}
