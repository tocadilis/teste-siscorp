package br.com.siscorp.tokio.prova.usecase.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;
import br.com.siscorp.tokio.prova.port.in.produto.DetalheProdutoService;
import br.com.siscorp.tokio.prova.port.out.produto.DetalheProdutoPort;

@Component
public class DetalheProdutoUseCase implements DetalheProdutoService {

	private final DetalheProdutoPort detalheProdutoPort;

	public DetalheProdutoUseCase(DetalheProdutoPort detalheProdutoPort) {
		super();
		this.detalheProdutoPort = detalheProdutoPort;
	}

	@Override
	public List<Produto> obterTodos() {
		return detalheProdutoPort.obterTodos();
	}

	@Override
	public Produto obterPorId(long id) {
		return detalheProdutoPort.buscarPorId(id).orElse(null);
	}

	@Override
	public Produto incluirProduto(Produto produto) {
		return detalheProdutoPort.incluirProduto(produto);
	}

	@Override
	public void deletarProduto(long id) {
		detalheProdutoPort.deletarProduto(id);
	}

	@Override
	public Page<ProdutoJpaEntity> findAllPageable(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return detalheProdutoPort.findAllPageable(pageRequest);
	}

}
