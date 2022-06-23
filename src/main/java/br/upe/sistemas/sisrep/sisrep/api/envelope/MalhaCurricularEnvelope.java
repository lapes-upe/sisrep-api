package br.upe.sistemas.sisrep.sisrep.api.envelope;

import java.io.File;
import java.util.List;
import org.joda.time.DateTime;
import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import br.upe.sistemas.sisrep.sisrep.core.disciplina.Disciplina;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MalhaCurricularEnvelope {
  private Long id;
  private String codigo;
  private DateTime anotImplantacao;
  private File parecerCEE;
  private Curso curso;
  private List<Disciplina> disciplinas;
}
