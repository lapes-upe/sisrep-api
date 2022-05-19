package br.upe.sistemas.sisrep.base;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenciador")
    private Long id;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_alteracao")
    @LastModifiedDate
    private LocalDateTime dataAlteracao;

    // @Column(name = "criado_por")
    // @CreatedBy
    // private String criadoPor;

    // @Column(name = "alterado_por")
    // @LastModifiedBy
    // private String alteradoPor;
}
