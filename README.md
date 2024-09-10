kafka Implementation
start zookeeper

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start Kafka Broker:

.\bin\windows\kafka-server-start.bat .\config\server.properties

application.properties of kafka

spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
spring.kafka.consumer.auto-offset-reset=earliest
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer


docker command
--Start Kafka and Zookeeper using Docker Compose:
docker-compose up -d
--Stop Containers:
docker-compose down
--Verify that Kafka is running and functioning by listing Kafka topics again:
docker exec kafka kafka-topics.sh --list --bootstrap-server localhost:9092


