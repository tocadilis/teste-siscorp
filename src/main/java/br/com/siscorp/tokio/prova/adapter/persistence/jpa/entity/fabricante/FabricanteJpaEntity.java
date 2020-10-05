package br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.fabricante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.base.BaseJpaEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FABRICANTE")
@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class FabricanteJpaEntity extends BaseJpaEntity {

    private static final long serialVersionUID = 1L;
   
    @NotNull
    @NotBlank(message = "Campo Nome fantasia obrigatório")
    @Size(min = 3, max = 50)
    @Column(length = 50)
    private String nomeFantasia;

    @NotNull
    @NotBlank(message = "Campo Razão Social obrigatório")
    @Size(min = 3, max = 50)
    @Column(length = 50)
    private String razaoSocial;
    
    @NotNull
    private Long cnpj;
  

}
