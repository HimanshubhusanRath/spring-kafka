package com.hr.inactive.domain.consumer.config;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hr.domain.common.Domain;


@Configuration
public class InactiveDomainConsumerConfig {

	@Bean
	public Consumer<KStream<String, Domain>> inactiveDomainConsumer()
	{
		return kstream -> kstream.foreach((key,domain) -> {
			System.out.println(String.format("Consumed the INACTIVE domain with name [%s] and active = [%s]",domain.getDomain(), !domain.isDead()));
		});
	}
}
