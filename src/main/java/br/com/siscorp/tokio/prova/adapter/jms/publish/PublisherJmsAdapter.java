package br.com.siscorp.tokio.prova.adapter.jms.publish;


import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;
import br.com.siscorp.tokio.prova.port.out.produto.JmsPublisherService;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PublisherJmsAdapter implements JmsPublisherService{

	private final JmsTemplate jmsTemplate;

	private final Queue queue;

	public PublisherJmsAdapter(JmsTemplate jmsTemplate, Queue queue) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.queue = queue;
	}

	@Override
	public void publishMessage(Produto produto) {
		jmsTemplate.convertAndSend(queue, produto);
		log.info("Message published : " + produto);
	}
}
