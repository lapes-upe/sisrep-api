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
import br.upe.sistemas.sisrep.sisrep.core.malhaCurricular.MalhaCurricular;
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

  @NotBlank(message = "A carga horária teórica é obrigatória")
  private int cargaHorariaTeorica;

  @NotBlank(message = "A carga horária prática é obrigatória")
  private int cargaHorariaPratica;

  @NotBlank(message = "O período é obrigatório")
  private int periodo;

  @NotBlank(message = "Os pré-requisitos da disciplina é obrigatório")
  private List<Disciplina> preRequisitos;

  @NotBlank(message = "Os có-requisitos da disciplina é obrigatório")
  private List<Disciplina> coRequisitos;

  @NotBlank(message = "A ementa é obrigatória")
  private File ementa;

  @NotBlank(message = "O malha curricular é obrigatória")
  @ManyToOne
  private MalhaCurricular malhaCurricular;
}
