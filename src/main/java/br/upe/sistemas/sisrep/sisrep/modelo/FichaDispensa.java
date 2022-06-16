package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.ManyToMany;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

public class FichaDispensa {
  Usuario usuario;
  @ManyToMany
  List<Disciplina> disciplinas;
  StatusReaproveitamentoDisciplinaEnum status;
}
