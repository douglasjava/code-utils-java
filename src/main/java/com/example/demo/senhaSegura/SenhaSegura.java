package com.example.demo.senhaSegura;

import java.util.regex.Pattern;

public class SenhaSegura {

    private static final String PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    private static Pattern pattern = Pattern.compile(PATTERN);


    public static void main(String[] args) {
        String passwd = "a1ZOa47@";
        System.out.println(String.format("Senha %s é %s", passwd, isSenhaSegura(passwd)));

    }

    private static boolean isSenhaSegura(String senha) {
        boolean senhaValida;
        boolean isCaracterRepetido;

        senhaValida = pattern.matcher(senha).matches();

        if(!senhaValida) return false;

        String caracterAtual = "";
        String caracterAnterior = "";
        for (int i = 0; i < senha.length(); i++) {
            if(i == 0) {
                caracterAtual = String.valueOf(senha.charAt(i));
                caracterAnterior = caracterAtual;
            } else {

                caracterAtual = String.valueOf(senha.charAt(i));
                isCaracterRepetido = caracterAtual.equals(caracterAnterior);

                if(isCaracterRepetido) {
                    senhaValida = false;
                    break;
                } else {
                    caracterAnterior = String.valueOf(senha.charAt(i));
                }
            }

        }

        return senhaValida;

    }

}
