package br.upe.sistemas.sisrep.sisrep.modelo;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import br.upe.sistemas.sisrep.controleacesso.core.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Table(name = "ficha_dispensa", schema = "public")
public class FichaDispensa {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  private Usuario usuario;

  @ManyToMany
  List<Disciplina> disciplinas;
  private StatusReaproveitamentoDisciplinaEnum status;
}
