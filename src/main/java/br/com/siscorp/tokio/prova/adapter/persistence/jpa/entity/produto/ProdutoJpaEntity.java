package br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.base.BaseJpaEntity;
import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.fabricante.FabricanteJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUTO")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ProdutoJpaEntity extends BaseJpaEntity {

    private static final long serialVersionUID = 1L;
        
    @NotNull
    @NotBlank(message = "Campo Nome obrigatório")
    @Size(min = 3, max = 25)
    @Column(length = 25)
    private String nome;
   
    @NotNull
    @NotBlank(message = "Campo EAN obrigatório")
    @Column(length = 20)
    private String ean;
    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private FabricanteJpaEntity fabricante;

}
