package br.upe.sistemas.sisrep.controleacesso.api.vos;

import javax.persistence.Lob;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PerfilUsuarioVO {
  private String nome;

  @Lob
  private byte[] icone;
}
