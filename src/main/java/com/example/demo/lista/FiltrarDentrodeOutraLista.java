package com.example.demo.lista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FiltrarDentrodeOutraLista {

	public static void main(String[] args) {
		
		System.out.println(new Date());
		
		List<FolApiElektroMailsPix> faturas = new ArrayList<>();
		FolApiElektroMailsPix f1 = new FolApiElektroMailsPix();
		f1.setChaveValidaPix("123456789");
		FolApiElektroMailsPix f2 = new FolApiElektroMailsPix();
		f2.setChaveValidaPix("923456789");
		FolApiElektroMailsPix f3 = new FolApiElektroMailsPix();
		f3.setChaveValidaPix("923451789");
		faturas.add(f1);
		faturas.add(f2);
		faturas.add(f3);
		
		List<DadosPix> dadosPix = new ArrayList<>();
		DadosPix dado = new DadosPix();
		dado.setFatura("123456789");
		DadosPix dado1 = new DadosPix();
		dado1.setFatura("923456700");
		dadosPix.add(dado);
		dadosPix.add(dado1);
		
		//Tem nas duas listas
		faturas.stream()
			.filter(faturaBanco -> !dadosPix.stream().map(DadosPix::getFatura)
			.noneMatch(pix -> pix.equals(faturaBanco.getChaveValidaPix())))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Contém na lista principal e não na de DadosPIx
		faturas.stream()
			.filter(faturaBanco -> !dadosPix.stream().map(DadosPix::getFatura)
			.anyMatch(pix -> pix.equals(faturaBanco.getChaveValidaPix())))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		//Contém na lista de Pix e não tem na lista principal
		List<DadosPix> dadosPixFiltrado = dadosPix.stream()
			.filter(pix -> !faturas.stream().map(FolApiElektroMailsPix::getChaveValidaPix)
			.anyMatch(fatura -> fatura.equals(pix.getFatura())))
			.collect(Collectors.toList());
		
		System.out.println(dadosPixFiltrado);
		
	}
	
	
	
}

