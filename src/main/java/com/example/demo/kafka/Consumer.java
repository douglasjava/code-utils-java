package com.example.demo.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * Para teste subir o kafka e criar o topic
 * <p>
 * 
 * <b>Criar o topic</b>
 * <p>
 * .\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic
 * testejava
 * <p>
 * 
 * <b>Subir o zookeeper</b>
 * <p>
 * cd C:\kafka\bin\windows
 * <p>
 * .\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
 * <p>
 * 
 * <b>Subir o kafka</b>
 * <p>
 * cd C:\kafka\bin\windows
 * <p>
 * .\kafka-server-start.bat C:\kafka\config\server.properties
 * <p>
 * 
 * @author Marques
 *
 */
public class Consumer {
	
	private static final String TOPIC_NAME = "topico.comando.teste";

	public static void main(String[] args) {

		var properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_1");

		// Informar que quero pegar as mensagens desde da mais antiga
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		try (var consumer = new KafkaConsumer<String, String>(properties)) {

			consumer.subscribe(Arrays.asList(TOPIC_NAME));

			while (true) {

				// tempo que ele ficara aguardando a mensagem
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

				for (ConsumerRecord<String, String> record : records) {
					System.out.println(record.value());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		}

	}

}
