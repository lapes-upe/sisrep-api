package br.upe.sistemas.sisrep.controleacesso.core;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.upe.sistemas.sisrep.base.Entidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "perfil", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "perfil_seq", allocationSize = 1,
        schema = "acesso")
public class Perfil extends Entidade {
    private String nome;
}
