package com.hr.springboot.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.hr.springboot.kafka.message.User;

@SpringBootApplication
public class SpringbootKafkaExampleApplication {

	
	@Value("${topic.name}")
	private String topicName;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaExampleApplication.class, args);
	}
	
	// Producer
	@Bean
	CommandLineRunner commandLineRunner(final KafkaTemplate<String, Object> kafkaTemplate)
	{
		return args -> {
				// Send a string
				kafkaTemplate.send(topicName, "My String messages");
				// Send an object
				kafkaTemplate.send(topicName, new User(1,"Himanshu"));
		};
	}

	
}
