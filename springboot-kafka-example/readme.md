Project Flow
------------
1. Producer:
     - Uses the KakfaTemplate and sends message to kafka when the application starts.
2. Consumer:
     - Registered with @KafkaListener with the topic name.
     - Listens to the topic and reads a message as soon as it is available in the topic.


