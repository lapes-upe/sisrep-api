package br.upe.sistemas.sisrep.controleacesso.api.vos;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssociarPerfilVO {

  @NotBlank(message = "O email é obrigatório")
  private String email;

  @NotBlank(message = "O perfil é obrigatório")
  private String perfil;
}
