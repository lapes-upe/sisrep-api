package br.upe.sistemas.sisrep.controleacesso.core;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "usuario", schema = "acesso")
@SequenceGenerator(name = "sequenciador", sequenceName = "usuario_seq", allocationSize = 1,
        schema = "acesso")
public class Usuario extends Entidade {
    private String nome;
    private String email;
    private String cpf;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil"), schema = "acesso")
    private List<Perfil> perfis;

}
