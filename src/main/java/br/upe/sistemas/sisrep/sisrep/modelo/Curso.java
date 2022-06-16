package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Curso {
  String nome;
  @OneToMany(mappedBy = "curso")
  List<Disciplina> disciplinas;
  @ManyToOne
  InstituicaoEnsino instituicaoEnsino;
}
