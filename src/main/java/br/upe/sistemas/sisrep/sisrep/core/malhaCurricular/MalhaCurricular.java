package br.upe.sistemas.sisrep.sisrep.core.malhaCurricular;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.joda.time.DateTime;
import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "malha_curricular", schema = "public")
public class MalhaCurricular {
  private String codigo;

  private DateTime anoImplantacao;

  @ManyToOne
  private Curso curso;

  @OneToMany(mappedBy = "malha_curricular")
  private List<Disciplina> disciplinas;

  private File parecerCEE;
}
