package br.upe.sistemas.sisrep.sisrep.core.fichaDispensa;

import java.io.File;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "ficha_dispensa", schema = "public")
public class FichaDispensa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne
  private Disciplina disciplina;

  private StatusReaproveitamentoDisciplinaEnum status;

  private List<File> documentacao;
}
