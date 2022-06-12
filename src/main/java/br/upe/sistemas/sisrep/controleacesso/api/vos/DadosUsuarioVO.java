package br.upe.sistemas.sisrep.controleacesso.api.vos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DadosUsuarioVO {
  private String email;
  private String nome;
  private String endereco;
  private String cidade;
  private String cep;
  private String celular;
}
