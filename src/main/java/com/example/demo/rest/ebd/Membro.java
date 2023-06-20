package com.example.demo.rest.ebd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Membro {

   private String nome;
   private String cpf;
   private String celular;
   private String email;
   private Denominacao denominacao;
   private Funcao funcao;

}

