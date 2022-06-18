package br.upe.sistemas.sisrep.sisrep.api.vos;

import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplinaVO {
  private Long id;
  private String nome;
  private int cargaHoraria;
  private double media;
  private Curso curso;
}
