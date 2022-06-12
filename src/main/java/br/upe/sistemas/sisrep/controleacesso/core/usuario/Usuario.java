package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import br.upe.sistemas.sisrep.base.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "email"}, callSuper = false)
@Table(name = "usuario", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "usuario_seq", allocationSize = 1,
    schema = "acesso")
public class Usuario extends Entidade {

  private byte[] foto;

  @Email(message = "O email deve ser válido")
  private String email;

  @NotBlank(message = "O nome é obrigatório")
  @Size(message = "O nome deve ter entre 5 e 200 caracteres", min = 5, max = 200)
  private String nome;

  private String endereco;

  private String cidade;

  private String cep;

  private String celular;

  @NotBlank(message = "O cpf é obrigatório")
  @CPF(message = "Informe o cpf no formato válido")
  private String cpf;

  private String token;

  @NotNull(message = "Informe se o usuário está ativo")
  private Boolean ativo;

  @NotEmpty(message = "O usuário deve ter ao menos um perfil associado")
  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      targetEntity = Perfil.class)
  @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"),
      inverseJoinColumns = @JoinColumn(name = "id_perfil"), schema = "acesso")
  private List<Perfil> perfis;

}
