package br.upe.sistemas.sisrep.sisrep.modelo;

import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import lombok.Data;

@Data
public class Disciplina {
  private String nome;
  private int cargaHoraria;
  private double media;
  private InstituicaoEnsino instituicaoEnsino;
  private Usuario usuario;
}
