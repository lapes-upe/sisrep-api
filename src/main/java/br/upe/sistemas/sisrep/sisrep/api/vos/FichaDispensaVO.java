package br.upe.sistemas.sisrep.sisrep.api.vos;

import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import br.upe.sistemas.sisrep.sisrep.core.fichaDispensa.StatusReaproveitamentoDisciplinaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FichaDispensaVO {
  private Long id;
  private Usuario usuario;
  private StatusReaproveitamentoDisciplinaEnum status;
}
