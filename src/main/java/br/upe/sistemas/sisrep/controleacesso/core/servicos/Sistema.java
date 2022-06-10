package br.upe.sistemas.sisrep.controleacesso.core.servicos;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.upe.sistemas.sisrep.base.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(of = { "id", "nome" }, callSuper = false)
@Table(name = "sistema", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "sistema_seq", allocationSize = 1, schema = "acesso")
public class Sistema extends Entidade {

	private String nome;
	private String descricao;
	private String link;

	@Lob
	private byte[] icone;
}
