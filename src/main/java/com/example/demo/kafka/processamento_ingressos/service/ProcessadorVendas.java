package com.example.demo.kafka.processamento_ingressos.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.example.demo.kafka.processamento_ingressos.core.VendasDeserializer;
import com.example.demo.kafka.vendas_ingressos.config.ConfigKafka;
import com.example.demo.kafka.vendas_ingressos.model.Venda;

public class ProcessadorVendas {

	public static void main(String[] args) {

		var properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VendasDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-processamento");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10");

		try (var consumer = new KafkaConsumer<String, Venda>(properties)) {

			consumer.subscribe(Arrays.asList(ConfigKafka.TOPIC));

			while (true) {

				// tempo que ele ficara aguardando a mensagem
				ConsumerRecords<String, Venda> records = consumer.poll(Duration.ofSeconds(1));

				for (ConsumerRecord<String, Venda> record : records) {

					Venda venda = record.value();
					if (new Random().nextBoolean()) {
						venda.setStatus("APROVADA");
					} else {
						venda.setStatus("REPROVADA");
					}
					
					Thread.sleep(500);
					
					System.out.println(venda);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		}

	}

}
