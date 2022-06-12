package br.upe.sistemas.sisrep.controleacesso.api.vos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SistemaVO {

	private Long id;
	private String nome;
	private String descricao;
	private String link;
	private byte[] icone;
}
