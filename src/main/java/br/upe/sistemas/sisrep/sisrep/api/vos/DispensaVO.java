package br.upe.sistemas.sisrep.sisrep.api.vos;

import java.io.File;
import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import br.upe.sistemas.sisrep.sisrep.core.reaproveitamentoDisciplina.dispensa.StatusReaproveitamentoDisciplinaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DispensaVO {
  private Long id;
  private StatusReaproveitamentoDisciplinaEnum status;
  private List<File> documentacao;
  private Disciplina disciplina;
}
