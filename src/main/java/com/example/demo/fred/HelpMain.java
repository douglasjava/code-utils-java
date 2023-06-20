package com.example.demo.fred;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HelpMain {

    private static RegistroRepository registroRepository;

    private List<Registros> recuperarRegistrosQuantidades(Date stDate, Date edDate, Integer idStatus, List<Credores> credoresSelecionados) {

        try{

            //Filtrando a lista de credores com o nome TODOS e transformando numa lista de Integer de ids do credores
            List<Integer> idCredores = credoresSelecionados.stream()
                    .filter(credores -> "TODOS".equalsIgnoreCase(credores.getNmCredor()))
                    .map(Credores::getIdCredor)
                    .collect(Collectors.toList());

            //Se a lista tiver algum credor com TODOS a pesquisa será feita sem ids
            if(idCredores.isEmpty()) {
                if (idStatus == 0) {
                    return registroRepository.findRegistrosQuantitativo(stDate, edDate);
                } else {
                    return registroRepository.findRegistrosQuantitativo(stDate, edDate, idStatus);
                }
            } else {
                if(idStatus == 0) {
                    return registroRepository.findRegistrosQuantitativo(stDate, edDate, idCredores);
                } else {
                    return registroRepository.findRegistrosQuantitativo(stDate, edDate, idStatus, idCredores);
                }
            }

        } catch(Exception e) {
            //log.error("Falha ao gerar relatório de Quatitativo. {}", e);
            //log.error("",e);
            return null;
        }

    }

}
