package br.com.siscorp.tokio.prova.adapter.web;

import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api/publish")
@RestController
public class PublisherController {

	private final JmsTemplate jmsTemplate;

	private final Queue queue;

	public PublisherController(JmsTemplate jmsTemplate, Queue queue) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.queue = queue;
	}

	@GetMapping("/{msg}")
	public String publishMessage(@PathVariable("msg") String content) {
		jmsTemplate.convertAndSend(queue, content);
		log.info("Message published : " + content);
		return "Success";
	}
}
