package br.upe.sistemas.sisrep.sisrep.api.vos;

import java.io.File;
import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import br.upe.sistemas.sisrep.sisrep.core.fichaDispensa.StatusReaproveitamentoDisciplinaEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FichaDispensaVO {
  private Long id;
  private List<Disciplina> disciplinas;
  private StatusReaproveitamentoDisciplinaEnum status;
  private List<File> documentacao;
}
