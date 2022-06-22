package br.upe.sistemas.sisrep.sisrep.api.vos;

import java.util.List;
import br.upe.sistemas.sisrep.sisrep.core.curso.Curso;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstituicaoVO {
  private Long id;
  private String nome;
  private String cidade;
  private String estado;
  private String codigoMEC;
  private List<Curso> cursos;
}
