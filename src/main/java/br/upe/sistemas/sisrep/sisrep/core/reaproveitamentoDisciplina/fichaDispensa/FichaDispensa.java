package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.Dispensa;
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

  @NotBlank(message = "O requerente é obrigatório")
  @ManyToOne
  private Usuario requerente;

  private String emailReceptorSolicitacao;
  private String emailEmissorParecer;
  private String emailAnalistaParecer;

  @OneToOne
  private Dispensa dispensaDisciplina;
}
