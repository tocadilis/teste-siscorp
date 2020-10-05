package br.com.siscorp.tokio.prova.adapter.jms.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;
import br.com.siscorp.tokio.prova.port.in.produto.DetalheProdutoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	private final DetalheProdutoService detalheProdutoService;
	
	public Consumer(DetalheProdutoService detalheProdutoService) {
		super();
		this.detalheProdutoService = detalheProdutoService;
	}

	@JmsListener(destination = "siscorp.tokio.queue")
	public void onMessage(Produto produto) {
		produto.setNome("INSERT PELA FILA");
		detalheProdutoService.incluirProduto(produto);
		log.info("Message received : " + produto);
	}
}