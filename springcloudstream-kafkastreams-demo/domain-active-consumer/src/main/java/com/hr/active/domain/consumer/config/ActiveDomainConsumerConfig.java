package com.hr.active.domain.consumer.config;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hr.domain.common.Domain;

@Configuration
public class ActiveDomainConsumerConfig {

	@Bean
	public Consumer<KStream<String, Domain>> activeDomainConsumer()
	{
		return kstream -> kstream.foreach((key,domain) -> {
			System.out.println(String.format("Consumed the ACTIVE domain with name [%s] and active = [%s]",domain.getDomain(), !domain.isDead()));
		});
	}
}
