package br.com.siscorp.tokio.prova.domain.entity.participante;

import br.com.siscorp.tokio.prova.domain.entity.base.Base;
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
public class Fabricante extends Base {

	private String nomeFantasia;

	private String razaoSocial;
    
    private Long cnpj;
    
}
