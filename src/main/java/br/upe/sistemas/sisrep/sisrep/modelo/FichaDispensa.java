package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import lombok.Data;

@Data
public class FichaDispensa {
  private List<Disciplina> disciplina;
  private StatusDisciplinaEnum status;
}
