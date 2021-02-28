package com.example.demo.kafka.vendas_ingressos.core;

import org.apache.kafka.common.serialization.Serializer;

import com.example.demo.kafka.vendas_ingressos.exception.SerializeDataException;
import com.example.demo.kafka.vendas_ingressos.model.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VendasSerializer implements Serializer<Venda> {

	@Override
	public byte[] serialize(String topic, Venda data) {

		try {

			return new ObjectMapper().writeValueAsBytes(data);

		} catch (Exception e) {
			throw new SerializeDataException("Falha ao serializar os dados da venda", e);

		}

	}

}
