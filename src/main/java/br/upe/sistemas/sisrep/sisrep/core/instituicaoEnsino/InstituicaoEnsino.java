package br.upe.sistemas.sisrep.sisrep.core.instituicaoEnsino;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "instituicao_ensino", schema = "public")
public class InstituicaoEnsino {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;

  @OneToMany
  private List<Curso> cursos;
}
