package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class FichaDispensa {
  @OneToMany
  private List<Disciplina> disciplina;
  private StatusDisciplinaEnum status;
}
