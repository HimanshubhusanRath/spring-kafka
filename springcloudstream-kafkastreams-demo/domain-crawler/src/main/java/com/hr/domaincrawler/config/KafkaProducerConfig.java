package com.hr.domaincrawler.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.hr.domain.common.Domain;

/**
 * 
 * Kafka configuration for producing messages to the kafka topic
 * 
 * 
 * @author himanshubhusan.rath
 *
 */
@Configuration
public class KafkaProducerConfig {

	@Bean
	public KafkaTemplate<String, Domain> kafkaTemplate()
	{
		return new KafkaTemplate<String, Domain>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, Domain> producerFactory() {
		final Map<String, Object> configs  =  new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	
}
