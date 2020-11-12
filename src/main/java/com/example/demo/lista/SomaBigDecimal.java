package com.example.demo.lista;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SomaBigDecimal {

	public static void main(String[] args) {
		//383.58
		
		List<DadosPix> dadosPixes = new ArrayList<>();
        DadosPix dados = new DadosPix();
        dados.setValor(new BigDecimal(932.79));

        DadosPix dados1 = new DadosPix();
        dados1.setValor(new BigDecimal(201.15));

        dadosPixes.add(dados);
        dadosPixes.add(dados1);

        BigDecimal valor = dados.getValor().add(dados1.getValor());
        
		BigDecimal valorTotal = dadosPixes.stream()
				.map(DadosPix::getValor)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);

		BigDecimal vlr = formataDecimal(valorTotal);
		
		String vlr2 = vlr.toPlainString();
		
		System.out.println(vlr2);
		
		System.out.println(vlr2.replace(".", ""));
	}

	public static BigDecimal formataDecimal(BigDecimal vlrFator) {
		BigDecimal numFormatado = vlrFator.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return numFormatado;
	}
	
}
