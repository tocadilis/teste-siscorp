package br.com.siscorp.tokio.prova.adapter.web.dto.produto;

import br.com.siscorp.tokio.prova.adapter.web.dto.base.BaseDTO;
import br.com.siscorp.tokio.prova.adapter.web.dto.fabricante.FabricanteDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ProdutoDTO extends BaseDTO {

    private String nome;
    
    private String ean;

    private FabricanteDTO fabricante;


}
