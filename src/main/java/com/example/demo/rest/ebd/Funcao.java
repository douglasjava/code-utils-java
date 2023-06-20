package com.example.demo.rest.ebd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Funcao {

    Obreiro("1"),
    Diacono("2"),
    Outros("8"),
    Professora("10"),
    Membro("9"),
    SenhoraFrente("5"),
    Pastor("4");

    private String codigo;

}
