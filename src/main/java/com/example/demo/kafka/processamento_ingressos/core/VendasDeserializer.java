package com.example.demo.kafka.processamento_ingressos.core;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.demo.kafka.vendas_ingressos.exception.SerializeDataException;
import com.example.demo.kafka.vendas_ingressos.model.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VendasDeserializer implements Deserializer<Venda> {

	@Override
	public Venda deserialize(String topic, byte[] data) {
		
		try {

			return new ObjectMapper().readValue(data, Venda.class);

		} catch (IOException e) {
			throw new SerializeDataException("Falha ao deserializar os dados da venda", e);

		}

	}

}
