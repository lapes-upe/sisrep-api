package br.upe.sistemas.sisrep.sisrep.api.envelope;

import java.io.File;
import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.StatusReaproveitamentoDisciplinaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DispensaEnvelope {
  private Long id;
  private StatusReaproveitamentoDisciplinaEnum status;
  private List<File> documentacao;
  private Disciplina disciplina;
}
