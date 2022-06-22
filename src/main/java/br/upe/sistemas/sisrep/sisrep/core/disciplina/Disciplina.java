package br.upe.sistemas.sisrep.sisrep.core.disciplina;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disciplina", schema = "public")
public class Disciplina {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "O nome é obrigatório")
  private String nome;

  @NotBlank(message = "A carga horária é obrigatória")
  private int cargaHorariaTeorica;

  private int cargaHorariaPratica;

  private int periodo;

  private List<Disciplina> preRequisitos;

  private List<Disciplina> coRequisitos;

  private File ementa;

  @NotBlank(message = "A média é obrigatória")
  private double media;

  @NotBlank(message = "O curso é obrigatório")
  @ManyToOne
  private Curso curso;
}
