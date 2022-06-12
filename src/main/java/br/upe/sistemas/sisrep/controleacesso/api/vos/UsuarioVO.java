package br.upe.sistemas.sisrep.controleacesso.api.vos;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioVO {

  private Long id;
  private String email;
  private String nome;
  private String cpf;
  private String token;
  private Boolean ativo;

  private List<PerfilVO> perfis;
}
