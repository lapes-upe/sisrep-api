package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISistemaRepositorio extends JpaRepository<Sistema, Long> {

}
