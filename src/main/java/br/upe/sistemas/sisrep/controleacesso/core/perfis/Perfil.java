package br.upe.sistemas.sisrep.controleacesso.core.perfis;

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
@EqualsAndHashCode(callSuper = false) // Falta passar o parametro of
@Table(name = "perfil", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "usuario_seq", allocationSize = 1, schema = "acesso")
public class Perfil extends Entidade {
	private String nome;
	
	@Lob
	private byte[] icone;
}
