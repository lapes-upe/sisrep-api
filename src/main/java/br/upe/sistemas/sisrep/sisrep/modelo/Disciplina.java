package br.upe.sistemas.sisrep.sisrep.modelo;

import javax.persistence.ManyToOne;

public class Disciplina {
  String nome;
  int cargaHoraria;
  double media;
  @ManyToOne
  Curso curso;
}
