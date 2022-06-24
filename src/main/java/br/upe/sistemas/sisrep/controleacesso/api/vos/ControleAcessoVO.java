package br.upe.sistemas.sisrep.controleacesso.api.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControleAcessoVO {

    private String nome;
    private String email;
    private String avatarPerfil;
    private String token;
    private String tokenExpiracao;
    private Boolean redirecionarCadastro;
    private List<PerfilUsuarioVO> perfis;

}
