package br.com.siscorp.tokio.prova.adapter.web.dto.fabricante;

import br.com.siscorp.tokio.prova.adapter.web.dto.base.BaseDTO;
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
public class FabricanteDTO extends BaseDTO {

	private String nomeFantasia;

	private String razaoSocial;
    
    private Long cnpj;
}
