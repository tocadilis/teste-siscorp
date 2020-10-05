package br.com.siscorp.tokio.prova.port.out.produto;

import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;

public interface JmsPublisherService {

	void publishMessage(Produto produto);

}
