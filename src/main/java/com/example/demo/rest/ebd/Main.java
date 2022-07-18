package com.example.demo.rest.ebd;


import com.example.demo.padraocodigo.interatorpattern.ArrayList;
import com.example.demo.padraocodigo.interatorpattern.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class Main {

    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public static final int QTDEPERGUNTAS = 7;
    public static final String EBDID = "2281";

    public static void main(String[] args) {

        System.out.println("Enviando respostas EBD: " + EBDID);

/*
        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicao(i, "DEBORA HELEN FERREIRA DIAS", "15920286679", "(31) 99768-1930", "deboraferreira9768@gmail.com", Funcao.Membro);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicao(i, "EUNICE MARIA FERREIRA DIAS", "02003986790", "(31) 99768-1930", "deboraferreira9768@gmail.com", Funcao.Membro);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicao(i, "CRESOLINO MARQUES DIAS", "92458238734", "(31) 9704-3807", "crisolinomarques@yahoo.com.br", Funcao.Pastor);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicao(i, "MARIA DAS GRAÇAS RIBEIRO", "65837525068", "(31) 98680-0864", "mariah.maranata@gmail.com", Funcao.SenhoraFrente);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicaoDebora(i);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicaoDouglas(i);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicao(i, "ANA LUISA CARDOSO DE ALMEIDA", "01968633685", "(31) 99550-7717", "analora1710@gmail.com", Funcao.Professora);
            call(request);
        }

*/

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicaoDebora(i);
            call(request);
        }

        for (int i = 0; i <= QTDEPERGUNTAS; i++) {
            var request = getContribuicaoDouglas(i);
            call(request);
        }


        System.out.printf("%s Respostas enviadas EBD: %s%n", QTDEPERGUNTAS, EBDID);

    }


    private static void call(Contribuicao request) {

        try {

            var url = "https://intregracao-site.presbiterio.org.br/api-ebd/cadastro-contribuicao";

            var response = getRestTemplate().postForEntity(url, request, String.class);

            System.out.println(response.getBody());

        } catch (HttpClientErrorException e) {
            ResponseEntity<String> teste = ResponseEntity
                    .status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());

            System.out.println(teste);
        }

    }

    public static String respostas(int index) {
        List<String> respostas = new ArrayList<>();

        respostas.add("1 - As coisas do Senhor não devem ser feitas de qualquer forma -> \n" +
                "Maldito aquele que fizer a obra do SENHOR relaxadamente! Jeremias 48:10");

        respostas.add("2 - 50.070 pessoas\n" +
                "obs: Há uma divergencia em algumas traduções sobre a quantidade de pessoas que morreram ");

        respostas.add("3 - O segredo foi: o Mistério, o Temor e a Glória - II Samuel 6:11.");

        respostas.add("4 - Maior feito de Davi: a conquista de Jerusalém II Samuel 5:6-10.");

        respostas.add("5 - \n" +
                ": O reinado de Davi em Hebrom\n" +
                " -> Exército de Davi, sob a liderança de Joabe vencem os homens de Isbosete, sob a liderança de Abner -: local: Gibeom\n" +
                ": O reinado de Davi em Jerusalém\n" +
                " -> Conquistar Jerusalém dos jebuseus\n" +
                " -> Davi ampliou e fortificou a cidade. Ali ele ergueu um palácio, restabeleceu rotas comerciais e construiu importantes estradas.\n" +
                " -> Trouxe a arca da aliança novamente para Jerusalém\n" +
                " -> Nesse tempo velhos opressores do povo de Israel foram dominados, tais como: filisteus, moabitas, amonitas, arameus, edomitas, amalequitas e cananeus em geral. ");

        respostas.add("6 - Com cânticos de vitórias. \n" +
                "Quem tem ouvidos, ouça o que o Espírito diz às igrejas: Ao que vencer darei eu \n" +
                "a comer do maná escondido, e dar-lhe-ei uma pedra branca, e na pedra um novo \n" +
                "nome escrito, o qual ninguém conhece senão aquele que o recebe. Apocalipse 2:17");

        respostas.add("7 - O segredo foi confiar no nome do Senhor dos Exércitos, o Deus de Israel");


        return respostas.get(index);
    }

    public static Contribuicao getContribuicaoDouglas(int index) {
        return Contribuicao.builder()
                    .nome("DOUGLAS MARQUES DIAS")
                    .cpf("10146710606")
                    .email("douglasmarquesdias@hotmail.com")
                    .celular("(31) 9563-9390")
                    .cidade("Contagem")
                    .uf("MG")
                    .funcao(Funcao.Diacono.name())
                    .funcao_id(Funcao.Diacono.getCodigo())
                    .trabalho_id("21")
                    .ebd_id(EBDID)
                    .categoria_id("2")
                    .aceite_termo("1")
                    .contribuicao(respostas(index))
                .build();
    }

    public static Contribuicao getContribuicaoDebora(int index) {
        return Contribuicao.builder()
                    .nome("DÉBORA DE OLIVEIRA MARQUES")
                    .cpf("13247067671")
                    .celular("(31) 9563-9390")
                    .email("dboraoliveiramarques@gmail.com")
                    .cidade("Contagem")
                    .uf("MG")
                    .funcao(Funcao.Professora.name())
                    .funcao_id(Funcao.Professora.getCodigo())
                    .trabalho_id("21")
                    .ebd_id(EBDID)
                    .categoria_id("2")
                    .aceite_termo("1")
                    .contribuicao(respostas(index))
                .build();
    }

    public static Contribuicao getContribuicao(int index, String nome, String cpf, String celular, String email, Funcao funcao) {
        return Contribuicao.builder()
                    .nome(nome)
                    .cpf(cpf)
                    .celular(celular)
                    .email(email)
                    .cidade("Contagem")
                    .uf("MG")
                    .funcao(funcao.name())
                    .funcao_id(funcao.getCodigo())
                    .trabalho_id("21")
                    .ebd_id(EBDID)
                    .categoria_id("2")
                    .aceite_termo("1")
                    .contribuicao(respostas(index))
                .build();
    }

}
