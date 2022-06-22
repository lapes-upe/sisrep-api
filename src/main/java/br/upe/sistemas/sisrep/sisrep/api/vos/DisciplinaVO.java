package br.upe.sistemas.sisrep.sisrep.api.vos;

import java.io.File;
import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import br.upe.sistemas.sisrep.sisrep.core.malhaCurricular.MalhaCurricular;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisciplinaVO {
  private Long id;
  private String nome;
  private int cargaHorariaTeorica;
  private int cargaHorariaPratica;
  private int periodo;
  private List<Disciplina> preRequisitos;
  private List<Disciplina> coRequisitos;
  private File ementa;
  private MalhaCurricular malha;
}
