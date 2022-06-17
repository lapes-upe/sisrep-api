package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Table(name = "curso", schema = "public")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;

  @OneToMany(mappedBy = "curso")
  private List<Disciplina> disciplinas;

  @ManyToOne
  private InstituicaoEnsino instituicaoEnsino;
}
