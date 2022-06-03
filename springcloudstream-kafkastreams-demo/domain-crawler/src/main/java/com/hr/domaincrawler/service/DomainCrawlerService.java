package com.hr.domaincrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hr.domain.common.Domain;
import com.hr.domain.common.DomainList;

import reactor.core.publisher.Mono;

@Service
public class DomainCrawlerService {

	@Value("${topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, Domain> kafkaTemplate;
	
	public void crawl(final String domainName) {
		
		final Mono<DomainList> domainList= WebClient
			.create()
			.get()
			.uri("https://api.domainsdb.info/v1/domains/search?domain="+domainName)
			.retrieve()
			.bodyToMono(DomainList.class);
		
		domainList.subscribe(domainsList ->
				{
					domainsList.getDomains().forEach(domain->
					{
						kafkaTemplate.send(topicName,domain);
						System.out.println("Publishing a domain to the domains-topic");
					});
				});
	}

}
