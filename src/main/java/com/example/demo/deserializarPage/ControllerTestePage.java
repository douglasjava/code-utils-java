package com.example.demo.deserializarPage;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ControllerTestePage {

	public ComunicadoService service;

	@GetMapping
	public Page<Comunicado> lista() {
		return service.lista();
	}

}
