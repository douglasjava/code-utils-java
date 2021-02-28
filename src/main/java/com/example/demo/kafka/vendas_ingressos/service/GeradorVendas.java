package com.example.demo.kafka.vendas_ingressos.service;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.example.demo.kafka.vendas_ingressos.config.ConfigKafka;
import com.example.demo.kafka.vendas_ingressos.core.VendasSerializer;
import com.example.demo.kafka.vendas_ingressos.model.Venda;

public class GeradorVendas {

	private static final Random RANDOM = new Random();
	private static long operacao = 0;
	private static BigDecimal valorIngresso = BigDecimal.valueOf(500);

	public static void main(String[] args) {

		var properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, VendasSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendasSerializer.class.getName());

		try (var producer = new KafkaProducer<String, Venda>(properties)) {

			while (true) {
				
				Venda venda = gerarVenda();
				var record = new ProducerRecord<String, Venda>(ConfigKafka.TOPIC, venda);
				producer.send(record);
				
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

	}

	private static Venda gerarVenda() {
		long cliente = RANDOM.nextLong();
		int qtdeIngresso = RANDOM.nextInt(10);
		BigDecimal valorTotal = valorIngresso.multiply(valorIngresso);

		return new Venda(operacao++, cliente, qtdeIngresso, valorTotal);
	}

}
