package br.com.siscorp.tokio.prova.domain.entity.produto;

import br.com.siscorp.tokio.prova.domain.entity.base.Base;
import br.com.siscorp.tokio.prova.domain.entity.participante.Fabricante;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Produto extends Base{
	
	private String nome;
    
    private String ean;

    private Fabricante fabricante;

}
