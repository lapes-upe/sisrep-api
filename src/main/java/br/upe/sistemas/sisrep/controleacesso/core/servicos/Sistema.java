package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
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
@Table(name = "sistema", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "sistema_seq", allocationSize = 1, schema = "acesso")
public class Sistema extends Entidade {

  @NotBlank(message = "O nome é obrigatório")
  @Size(message = "O nome deve ter entre 5 e 200 caracteres", min = 5, max = 200)
  private String nome;

  @NotBlank(message = "A descrição é obrigatória")
  @Size(message = "A descrição deve ter entre 5 e 200 caracteres", min = 5, max = 200)
  private String descricao;

  @URL(protocol = "http", message = "O link do sistema é obrigatório")
  private String link;

  @NotNull(message = "O ícone do sistema é obrigatório")
  @Lob
  private byte[] icone;

  @NotNull(message = "Informe se o usuário está ativo")
  private Boolean ativo;

}
