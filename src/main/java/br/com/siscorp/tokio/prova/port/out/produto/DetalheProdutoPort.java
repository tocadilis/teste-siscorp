package br.com.siscorp.tokio.prova.port.out.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;

public interface DetalheProdutoPort {
	
    List<Produto> obterTodos();

    Optional<Produto> buscarPorId(long id);
    
    Produto incluirProduto(Produto produto);

    void deletarProduto(long id);

	Page<ProdutoJpaEntity> findAllPageable(PageRequest pageRequest);
}
