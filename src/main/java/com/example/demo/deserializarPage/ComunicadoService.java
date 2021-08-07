package com.example.demo.deserializarPage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComunicadoService {

	private ComunicadoRepository repository;

	public Page<Comunicado> lista() {

		return repository.findAll(PageRequest.of(0, 2));

	}

}
