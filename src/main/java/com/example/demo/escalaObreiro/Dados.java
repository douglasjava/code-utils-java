package com.example.demo.escalaObreiro;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class Dados {

    private static final String Ewerton = "Ewerton";
    private static final String Douglas = "Douglas";
    private static final String Claudio = "Cláudio";
    private static final String GabrielS = "Gabriel S.";
    private static final String GabrielO = "Gabriel O.";
    private static final String Alisson = "Alisson";
    private static final String JoaoMarcelo = "João Marcelo";
    private static final String Ministerio = "Ministério";
    private static final String Marcelo = "Marcelo";
    private static final String Samuel = "Samuel";
    private static final String Ricardo = "Ricardo";
    private static final String Fabio = "Fabio";

    public static List<String> getObreirosCultoPortaQuarta() {
        return Arrays.asList(Ewerton, Douglas);
    }

    public static List<String> getObreirosCultoPortaQuinta() {
        return Arrays.asList(Claudio, GabrielS, Alisson, JoaoMarcelo, Samuel, Ricardo);
    }

    public static List<String> getObreirosCultoPortaSabadoAndDomingoManha() {
        return Arrays.asList(Claudio, GabrielS, Alisson, JoaoMarcelo, Samuel, Ricardo);
    }

    public static List<String> getObreirosCultoPortaDomingoManhaNoite() {
        return Arrays.asList(Alisson, JoaoMarcelo, Samuel, Ricardo);
    }

    public static List<String> getObreirosCultoLouvor() {
        return Arrays.asList(Ewerton, Douglas, Claudio, GabrielS);
    }

    public static List<String> getObreirosCultoMensagem() {
        return Arrays.asList(Ewerton, Douglas, Claudio, GabrielS);
    }

    public static List<String> getObreirosMadrugada() {
        return Arrays.asList(Ewerton, Douglas, Claudio, GabrielS, GabrielO, Ministerio, Marcelo, Fabio);
    }

    public static List<String> getObreirosCultoPrincipal() {
        return Arrays.asList(Ewerton, Douglas, Claudio, GabrielS);
    }

    @Getter
    @AllArgsConstructor
    public enum DadosDias {

        MONDAY("Segunda-feira"),
        TUESDAY("Terça-feira"),
        WEDNESDAY("Quarta-feira"),
        THURSDAY("Quinta-feira"),
        FRIDAY("Sexta-feira"),
        SATURDAY("Sabado"),
        SUNDAY("Domingo manhã"),
        SUNDAY_NIGHT("Domingo noite");

        private String descricao;

    }

}

