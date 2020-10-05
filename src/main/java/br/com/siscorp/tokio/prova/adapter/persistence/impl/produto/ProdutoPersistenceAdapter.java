package br.com.siscorp.tokio.prova.adapter.persistence.impl.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.siscorp.tokio.prova.adapter.mapper.produto.ProdutoMapper;
import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.adapter.persistence.jpa.repository.produto.ProdutoJpaRepository;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;
import br.com.siscorp.tokio.prova.port.out.produto.DetalheProdutoPort;

@Component
public class ProdutoPersistenceAdapter implements DetalheProdutoPort {

	private final ProdutoJpaRepository produtoJpaRepository;

	public ProdutoPersistenceAdapter(ProdutoJpaRepository produtoJpaRepository) {
		super();
		this.produtoJpaRepository = produtoJpaRepository;
	}

	@Override
	public List<Produto> obterTodos() {
		return ProdutoMapper.mapToDomainEntity(produtoJpaRepository.findAll());
	}

	@Override
	public Optional<Produto> buscarPorId(long id) {
		return ProdutoMapper.mapToDomainEntity(produtoJpaRepository.findById(id));
	}

	@Override
	public Produto incluirProduto(Produto produto) {
		ProdutoJpaEntity produtoJpaEntity = ProdutoMapper.mapToJpaEntity(produto);
		return ProdutoMapper.mapToDomainEntity(produtoJpaRepository.save(produtoJpaEntity));
	}

	@Override
	public void deletarProduto(long id) {
		ProdutoJpaEntity produtoJpa = produtoJpaRepository.findById(id).orElseGet(null);
		produtoJpaRepository.delete(produtoJpa);
	}

	@Override
	public Page<ProdutoJpaEntity> findAllPageable(PageRequest pageRequest) {
		return produtoJpaRepository.findAllPageable(pageRequest);
	}
}
