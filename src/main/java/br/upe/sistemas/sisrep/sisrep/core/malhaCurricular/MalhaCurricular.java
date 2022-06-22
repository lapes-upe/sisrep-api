package br.upe.sistemas.sisrep.sisrep.core.malhaCurricular;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "O código é obrigatório")
  private String codigo;

  @NotBlank(message = "O ano de implantação é obrigatório")
  private DateTime anoImplantacao;

  @NotBlank(message = "O parecer CEE é obrigatório")
  private File parecerCEE;

  @NotBlank(message = "O curso é obrigatório")
  @ManyToOne
  private Curso curso;

  @OneToMany(mappedBy = "malha_curricular")
  private List<Disciplina> disciplinas;
}
