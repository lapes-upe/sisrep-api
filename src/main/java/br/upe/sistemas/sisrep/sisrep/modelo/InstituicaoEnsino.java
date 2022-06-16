package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.OneToMany;

public class InstituicaoEnsino {
  String nome;
  @OneToMany(mappedBy = "instituicao_nsino")
  List<Curso> cursos;
}
