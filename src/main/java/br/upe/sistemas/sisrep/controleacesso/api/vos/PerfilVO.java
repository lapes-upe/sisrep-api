package br.upe.sistemas.sisrep.controleacesso.api.vos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerfilVO {

  private Long id;
  private String nome;
  private byte[] icone;
}
