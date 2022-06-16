package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;

public class FichaDispensa {
  Usuario usuario;
  List<Disciplina> disciplinas;
  StatusReaproveitamentoDisciplinaEnum status;
}
