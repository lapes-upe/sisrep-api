package br.upe.sistemas.sisrep.sisrep.api.vos;

import br.upe.sistemas.sisrep.sisrep.core.instituicao.Instituicao;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoVO {
  private Long id;
  private String nome;
  private Instituicao ies;
}
