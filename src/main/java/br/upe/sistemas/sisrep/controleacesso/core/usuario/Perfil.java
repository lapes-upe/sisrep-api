package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.upe.sistemas.sisrep.base.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "nome"}, callSuper = false)
@Table(name = "perfil", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "perfil_seq", allocationSize = 1,
    schema = "acesso")
public class Perfil extends Entidade {

  @NotBlank(message = "O nome é obrigatório")
  @Size(message = "O nome deve ter entre 5 e 20 caracteres", min = 5, max = 20)
  private String nome;

  // @NotBlank(message = "O ícone é obrigatório")
  private byte[] icone;
}
