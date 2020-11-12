package com.example.demo.lista;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListasStream {

	public static void main(String[] args) {
		agruparPorEmpresa(Arrays.asList(new RelatorioModel()));
	}
	
	 public static List<RelatorioModel> agruparPorEmpresa(List<RelatorioModel> relatorioAux) {
	        return relatorioAux.stream()
	                .filter(distinctByKey(RelatorioModel::getEmpresa))
	                .collect(Collectors.toList());
	 }
	 
	
    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

}
