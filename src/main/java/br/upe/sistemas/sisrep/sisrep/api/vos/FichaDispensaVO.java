package br.upe.sistemas.sisrep.sisrep.api.vos;

import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.Dispensa;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FichaDispensaVO {
  private Long id;
  private Usuario requerente;
  private String emailReceptorSolicitacao;
  private String emailEmissorParecer;
  private String emailAnalistaParecer;
  private Dispensa dispensaDisciplina;
}
