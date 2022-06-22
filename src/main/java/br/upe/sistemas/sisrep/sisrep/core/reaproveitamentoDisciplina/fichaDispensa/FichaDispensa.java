package br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.fichaDispensa;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
  private Usuario requerente;
  private String emailReceptorSolicitacao;
  private String emailEmissorParecer;
  private String emailAnalistaParecer;

  @OneToOne
  private Dispensa dispensaDisciplina;
}
