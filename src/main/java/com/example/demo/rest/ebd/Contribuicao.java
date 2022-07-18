package com.example.demo.rest.ebd;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contribuicao {

    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String cidade;
    private String uf;
    private String funcao;
    private String funcao_id;
    private String trabalho_id;
    private String ebd_id;
    private String categoria_id;
    private String contribuicao;
    private String aceite_termo;

}
