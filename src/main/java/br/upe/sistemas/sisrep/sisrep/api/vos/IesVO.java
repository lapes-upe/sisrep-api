package br.upe.sistemas.sisrep.sisrep.api.vos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IesVO {
  private Long id;
  private String nome;
}
