package com.example.demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

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
public class Producer {

	private static final String TOPIC_NAME = "topico.comando.teste";
	
	public static void main(String[] args) {

		var properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		try (var producer = new KafkaProducer<String, String>(properties)) {

			for (int i = 0; i < 40; i++) {
				var record = new ProducerRecord<String, String>(TOPIC_NAME, "Mensagem: " + i);
				producer.send(record);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
