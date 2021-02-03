package com.example.demo.regras;

import org.apache.commons.lang3.StringUtils;

public class Regra1 {

	public static void main(String[] args) {

		String idExtraido = getId();
		String id = "";

		if (idExtraido.split("#").length <= 1) {
			System.err.println(false);
		}
		id = idExtraido.split("#")[1];

		System.out.println(Long.valueOf(id));

	}

	public static String preencherAEsquerdaComZeros(String str, int size) {
		return StringUtils.leftPad(str, size, "0");
	}

	private static String getId() {
		String id = "35601";
		String contrato = "7021387490";
		String dataString = "20201113";
		StringBuilder str = new StringBuilder();

		 //str.append("#").append(id).append("#").append(contrato).append("#").append(dataString);

		str.append(id).append(contrato).append(dataString);

		String idExtraido = preencherAEsquerdaComZeros(str.toString(), 35);

		System.out.println(idExtraido);

		return idExtraido;
	}

}
