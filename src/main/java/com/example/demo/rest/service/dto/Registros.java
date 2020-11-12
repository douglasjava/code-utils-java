package com.example.demo.rest.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Registros extends ArrayList<RegistroDiarioDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Registros {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		return o == null ? "null" : o.toString().replace("\n", "\n    ");
	}
}
