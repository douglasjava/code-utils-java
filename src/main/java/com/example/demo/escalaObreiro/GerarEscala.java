package com.example.demo.escalaObreiro;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static com.example.demo.escalaObreiro.Dados.*;

public class GerarEscala {

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(2022,2,1);
        gerarEscalaLouvor(data);

    }
    private static void gerarEscalaLouvor(LocalDate data) {

        for (int i = 1; i <= data.lengthOfMonth(); i++) {

            String format = "%-15.15s | %-15.15s | %15.15s\n";
            data = LocalDate.of(data.getYear(), data.getMonth(), i);

            if(isEqualsDayOfWeek(data, DayOfWeek.TUESDAY)) {

                System.out.printf(format, data, DadosDias.TUESDAY.getDescricao(), getNomeAleatorio(getObreirosMadrugada()));

            } else if(isEqualsDayOfWeek(data, DayOfWeek.THURSDAY)) {

                System.out.printf(format, data, DadosDias.THURSDAY.getDescricao(), getNomeAleatorio(getObreirosMadrugada()));

            } else if(isEqualsDayOfWeek(data, DayOfWeek.SATURDAY)) {

                System.out.printf(format, data, DadosDias.SATURDAY.getDescricao(), getNomeAleatorio(getObreirosMadrugada()));

            }

        }

    }

    private static void gerarEscalaPorta(LocalDate data) {
        for (int i = 1; i <= data.lengthOfMonth(); i++) {

            String format = "%-15.15s | %-15.15s | %15.15s\n";
            data = LocalDate.of(data.getYear(), data.getMonth(), i);

            if(isEqualsDayOfWeek(data, DayOfWeek.WEDNESDAY)) {

                System.out.printf(format, data, DadosDias.WEDNESDAY.getDescricao(), getNomeAleatorio(getObreirosCultoPortaQuarta()));

            } else if(isEqualsDayOfWeek(data, DayOfWeek.THURSDAY)) {

                System.out.printf(format, data, DadosDias.THURSDAY.getDescricao(), getNomeAleatorio(getObreirosCultoPortaQuinta()));

            } else if(isEqualsDayOfWeek(data, DayOfWeek.SATURDAY)) {

                System.out.printf(format, data, DadosDias.SATURDAY.getDescricao(), getNomeAleatorio(getObreirosCultoPortaSabadoAndDomingoManha()));

            } else if(isEqualsDayOfWeek(data, DayOfWeek.SUNDAY)) {

                System.out.printf(format, data, DadosDias.SUNDAY.getDescricao(), getNomeAleatorio(getObreirosCultoPortaDomingoManhaNoite()));
                System.out.printf(format, data, DadosDias.SUNDAY_NIGHT.getDescricao(), getNomeAleatorio(getObreirosCultoPortaDomingoManhaNoite()));
            }

        }
    }

    private static boolean isEqualsDayOfWeek(LocalDate data, DayOfWeek dayOfWeek) {
        return data.getDayOfWeek().equals(dayOfWeek);
    }

    private static String getNomeAleatorio(List<String> lista) {
        return lista.get(new Random().nextInt(lista.size()));
    }

}
