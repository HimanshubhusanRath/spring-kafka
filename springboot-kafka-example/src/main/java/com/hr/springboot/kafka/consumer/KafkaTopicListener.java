package com.hr.springboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicListener {

	@KafkaListener(
			topics = "${topic.name}",
			groupId = "indiaUserGroup")
	void listener(final ConsumerRecord<String, Object> message)
	{
		System.out.println("Consumed a message > "+ message.value());
	}
}
