package br.upe.sistemas.sisrep.sisrep.modelo;

import lombok.Data;

@Data
public class FichaDispensa {
  Disciplina disciplina;
  StatusDisciplinaEnum status;
}
