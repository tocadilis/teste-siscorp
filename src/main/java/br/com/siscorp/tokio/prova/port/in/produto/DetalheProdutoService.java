package br.com.siscorp.tokio.prova.port.in.produto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;

public interface DetalheProdutoService {

    List<Produto> obterTodos();

    Produto obterPorId(long id);
    
    Produto incluirProduto(Produto produto);
    
    void deletarProduto(long id);

	Page<ProdutoJpaEntity> findAllPageable(int page, int size);

}
