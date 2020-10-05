package br.com.siscorp.tokio.prova.adapter.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscorp.tokio.prova.adapter.mapper.produto.ProdutoMapper;
import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.adapter.web.dto.produto.ProdutoDTO;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;
import br.com.siscorp.tokio.prova.port.in.produto.DetalheProdutoService;
import br.com.siscorp.tokio.prova.port.out.produto.JmsPublisherService;

@CrossOrigin()
@RestController
@RequestMapping({ "/api/produtos" })
public class ProdutoController {

	private final DetalheProdutoService detalheProdutoService;

	private final JmsPublisherService jmsPublisherService;

	public ProdutoController(DetalheProdutoService detalheProdutoService, JmsPublisherService jmsPublisherService) {
		super();
		this.detalheProdutoService = detalheProdutoService;
		this.jmsPublisherService = jmsPublisherService;
	}

	@GetMapping()
	public List<ProdutoDTO> obterProdutos() {
		List<Produto> produtos = detalheProdutoService.obterTodos();
		return ProdutoMapper.mapToWebDTO(produtos);
	}

	@GetMapping("/findAllPageable")
	public Page<ProdutoJpaEntity> findAllPageable(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return detalheProdutoService.findAllPageable(page, size);
	}

	@GetMapping("/{id}")
	public ProdutoDTO obterProduto(@PathVariable("id") long id) {
		Produto produto = detalheProdutoService.obterPorId(id);
		return ProdutoMapper.mapToWebDTO(produto);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping
	public void incluirProduto(@RequestBody ProdutoDTO produtoDto) {
		Produto produto = ProdutoMapper.mapToDomainEntity(produtoDto);
		detalheProdutoService.incluirProduto(produto);
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/banco-jms")
	public void incluirProdutoNoBdEFila(@RequestBody ProdutoDTO produtoDto) {
		Produto produto = ProdutoMapper.mapToDomainEntity(produtoDto);
		Produto retorno = detalheProdutoService.incluirProduto(produto);
		jmsPublisherService.publishMessage(retorno);
	}

	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable("id") long id) {
		detalheProdutoService.deletarProduto(id);
	}

}