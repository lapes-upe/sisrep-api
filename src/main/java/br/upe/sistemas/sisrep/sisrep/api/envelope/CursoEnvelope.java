package br.upe.sistemas.sisrep.sisrep.api.envelope;

import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.instituicao.Instituicao;
import br.upe.sistemas.sisrep.sisrep.core.malhaCurricular.MalhaCurricular;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoEnvelope {
  private Long id;
  private String nome;
  private List<MalhaCurricular> malhas;
  private Instituicao instituicao;
}
