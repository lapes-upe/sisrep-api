package br.upe.sistemas.sisrep.controleacesso.core.usuario;

import javax.persistence.Entity;
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
@Table(name = "perfil", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "perfil_seq", allocationSize = 1,
        schema = "acesso")
public class TipoUsuario extends Entidade {
	
    private String nome;
}
