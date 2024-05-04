package com.example.demo.rest.ebd;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static final String CELULAR_DEFAULT = "31 9999-9999";
    public static final String EMAIL_DEFAULT = "membro@icm.com.br";

    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static final int QTDEPERGUNTAS = 1;
    public static final String EBDID = "4121";

    public static void main(String[] args) {

        var listMembers = getListMembersColorado();
        listMembers.addAll(getListMembersPalmares());
        listMembers.addAll(getOthers());

        System.out.println("Enviando respostas EBD: " + EBDID + " para " + listMembers.size() + " membros");


        AtomicInteger idx = new AtomicInteger(0);
        listMembers.forEach(membro -> {

            var request = getContribuicao(membro.getNome(),membro.getCpf(), membro.getCelular(), membro.getEmail(), membro.getFuncao());
            call(request);
            idx.getAndIncrement();

        });


        System.out.printf("%s Respostas enviadas EBD: %s%n", idx, EBDID);

    }

    private static List<Membro> getAfter() {
        List<Membro> members = new ArrayList<>();

        members.add(Membro.builder().nome("ESTEVAO SOBRINHO TRINDADE").cpf("11887179607").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());

        return members;
    }

    private static List<Membro> getOthers() {
        List<Membro> members = new ArrayList<>();

        members.add(Membro.builder().nome("DEBORA HELEN FERREIRA DIAS").cpf("15920286679").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());

        return members;
    }

    private static List<Membro> getListMembersPalmares() {
        List<Membro> members = new ArrayList<>();

        members.add(Membro.builder().nome("ADRIANA RIBEIRO MAXIMIANO DE SOUZA").cpf("02923801601").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("AMELIO NUNES GOUVEIA").cpf("99154102634").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("ARTHUR ASSIS COIMBRA DOS SANTOS").cpf("70148267602").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("CECÍLIA SOARES MACHADO").cpf("13362119620").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("EFIGENIA DAS GRACAS LEITE").cpf("81305737687").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("ELIANE DA LUZ BASTOS").cpf("01601798660").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("FÁBIO VIEIRA MORAIS").cpf("03854735677").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("FABRICIO RESENDE PEREIRA").cpf("77694929634").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("LUCAS FERNANDES DOS REIS").cpf("01419866621").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("MARIA MADALENA LOPES DE ARAUJO").cpf("04002728650").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("MARCIO ANTONIO DE ARAUJO").cpf("00163141665").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("PAULO ROGERIO MARTINS").cpf("56222564615").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("ROSE MARA SAMPAIO URSINI").cpf("39216225653").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("VIVIANE OLIVEIRA COIMBRA SANTOS").cpf("68102348615").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("WARLEY DOS SANTOS").cpf("53385586615").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
        members.add(Membro.builder().nome("YVES PAIVA DA SILVA").cpf("13145896601").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());

        return members;
    }


    private static List<Membro> getListMembersColorado() {

        List<Membro> members = new ArrayList<>();

       members.add(Membro.builder().nome("MARIA EDUARDA MIRANDA DE OLIVEIRA").cpf("18294305642").celular(CELULAR_DEFAULT).email("grazi_viola2009@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ANTÔNIO LUÍZ BATISTA MOREIRA").cpf("16334871641").celular("99764-7480").email("simonemlbmoreiraa@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUCAS ELIAS DA SILVA").cpf("14895195643").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ANA LUCIA QUIRINO").cpf("98546015600").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ANA LUISA CARDOSO DE ALMEIDA").cpf("01968633685").celular("(31) 99550-7717").email("analora1710@gmail.com").funcao(Funcao.Professora).build());
       members.add(Membro.builder().nome("CLAUDIO OLIVEIRA AUGUSTO").cpf("09479425645").celular("31 99891-1888").email("otrafegoin@gmail.com").funcao(Funcao.Obreiro).build());
       members.add(Membro.builder().nome("TEREZINHA BATISTA MONTEIRO").cpf("03575855692").celular("31 9946-9185").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DILMA DE SOUZA FERREIRA MEIRA").cpf("00157110648").celular("31 8234-4384").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("JOAO DA SILVA MEIRA").cpf("37303643672").celular("3180144594").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DOUGLAS MARQUES DIAS").cpf("10146710606").celular("3180144594").email("douglasmarquesdias@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DÉBORA DE OLIVEIRA MARQUES").cpf("13247067671").celular("(31) 9563-9390").email("dboraoliveiramarques@gmail.com").funcao(Funcao.Professora).build());
       members.add(Membro.builder().nome("BERNARDO ANTÔNIO MIRANDA DE OLIVEIRA").cpf("19307042675").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("HILDETE RODRIGUES BANDEIRA").cpf("02906924660").celular("(31) 99837-7778").email("hildeflorvida@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ISABEL GOMES BANDEIRA").cpf("73815632668").celular("(31) 99404-4674").email("izabelgomes022@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUISA CAROLINA COLHADO MACHADO").cpf("09400900660").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARATAISA COLHADO RIBEIRO").cpf("78599610678").celular("(31) 99999-9999").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALESSANDRA ANGELICA FIGUEIREDO SILVA").cpf("06374695690").celular("(31) 99999-9999").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALISON BUENO DA SILVA").cpf("02754654623").celular("(31) 98250-1874").email("alisonbueno@yahoo.com.br").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MATEUS BUENO DA SILVA FIGUEIREDO").cpf("70189937688").celular("(31) 3255-6789").email("wm@yahoo.com.br").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RITA ANGELICA DE JESUS SILVEIRA").cpf("28021002620").celular(CELULAR_DEFAULT).email("wm @yahoo.com.br").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("CRISTIANO ELIAS QUIRINO").cpf("04304133608").celular(CELULAR_DEFAULT).email("wm @yahoo.com.br").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("SILVIO DE JESUS ROCHA").cpf("85727911672").celular("(31) 97527-6529").email("Silvinho.jrocha@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("KETLYN DE OLIVEIRA PAULA").cpf("11398738654").celular("(31) 99329-6110").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("KHALYTA VITÓRIA DE OLIVEIRA PAULA").cpf("12626416673").celular("(31) 99533-4255").email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("JOAO RODRIGUES BANDEIRA").cpf("26583992604").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALESSANDRA RIBEIRO DE LANA").cpf("07185487609").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUIZ GUSTAVO RIBEIRO DE LANA").cpf("18295594605").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUANA RIBEIRO DE LANA").cpf("70163857601").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIA EDUARDA BUENO").cpf("70374725659").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DAVI BUENO DA SILVA FIGUEIREDO").cpf("70189934662").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALAIDE DIAS DE ALMEIDA").cpf("66354420653").celular("(31) 99743-6796").email("alaidealmeida22@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("SARA ELIAS ALVES QUIRINO").cpf("17015756633").celular("(31) 99663-9313").email("saraquirino@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("GRACIANE LOURENÇO DE FREITAS").cpf("06026171622").celular("(31) 98400-3537").email("gracianemartins17@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("WEBETY MAURÍCIO MARTINS").cpf("03293528651").celular("(31) 99337-9406").email("webertymm@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("SHEYLA FERNANDES DO CARMO").cpf("05919616601").celular("(31) 99554-6254").email("nathi123lu@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("NATHALIE ANNE FERNANDES DIETZE").cpf("17147113667").celular("(31) 99554-6254").email("nathi123lu@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("GERALDA ANTONIA FERNANDES DO CARMO").cpf("89981464600").celular("(31) 99999-1483").email("ageralda669@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ANDREIA DA ROCHA RODRIGUES DOLABELA").cpf("74394509653").celular(CELULAR_DEFAULT).email("membro@icm.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUCAS GABRIEL FERNANDES SOUZAA").cpf("17147192605").celular("(31) 9529-8371").email("nathi123lu@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ELOAH ALLANIS FERNANDES DE SOUSA").cpf("18314196614").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALTAMIRO DE CASTRO FILHO").cpf("71155252691").celular("(31) 98025-3532").email("decastrofilhoaltamiro3 @Gmail.co.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("GABRIELA OLIVEIRA RAMOS").cpf("15788896690").celular("(31) 8272-0102").email("gabi.o.ramos2004@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIA DAS DORES OLIVEIRA RAMOS").cpf("55611613691").celular("(31) 98386-5603").email("mariadas.dorrsoliveira @hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIA APARECIDA DIAS RODRIGUES DA SILVA").cpf("87932873649").celular("(31) 98844-7527").email("aparecidadias70@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ALAIDE ALVES QUIRINO").cpf("02955716677").celular("(31) 99596-6443").email("alaidealves43@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LENY MARIA DE OLIVEIRA").cpf("02632274648").celular("(31) 98575-9954").email("grazi_viola2009@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("VANESSA OLIVEIRA FERREIRA").cpf("68904304687").celular("(31) 99201-8170").email("denise.cassia@yahoo.com.br").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RANA ZAIRA FERREIRA RODRIGUES").cpf("70391240684").celular("(31) 99225-3666").email("ferreirarana919@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RYAN THALES FERREIRA RODRIGUES").cpf("70375167676").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("KEROLAINE SCHORNES RODRIGUES").cpf("14441569696").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LÍVIA BARCELOS DE OLIVEIRA ").cpf("10132870614").celular("(31) 98586-6359").email("liviahbarcellos@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("PAULINA APARECIDA AMARAL").cpf("57655502668").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("CRISTIANO LIMA MOREIRA").cpf("07243801676").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("THAYS KAREN ALVES PINTO").cpf("10109297636").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("JÚLIA VICTORIA ALVES LIMA").cpf("15147545689").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ESTEVÃO DE FREITAS MARTINS").cpf("17943936680").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIA DE JESUS REIS").cpf("29323649600").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("EXPEDITO ANTONIO PEREIRA").cpf("25490184604").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIO ALEXIS HERNANDEZ PINEDA ").cpf("70617672601").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LUCIANO FRANCISCO DA SILVA").cpf("03463291673").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DAVID OLIVEIRA DA SILVA").cpf("04966735645").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("JULIANA OLIVEIRA RAMOS").cpf("10166899690").celular("(31) 99144-0481").email("juliana.oliveiraramos@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIANA ALVES PEREIRA DE SOUZA").cpf("05972484609").celular("(31) 99292-7886").email("maryana.souza2011@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RONIERE ALVES PEREIRA DE SOUZA").cpf("01257813692").celular("(31) 98866-2890").email("ronidesouza11@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DAVI ALVES PEREIRA DE SOUZA").cpf("70256988650").celular("(31) 98372-3225").email("ronidesouza11@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARINA ALVES PEREIRA DE SOUZA").cpf("17842512671").celular("(31) 98866-2890").email("maryana.souza2011@hotmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LARA VITÓRIA DE FREITAS MARTINS").cpf("02341944647").celular(CELULAR_DEFAULT).email("laravitoriafmartins@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARIANA CAMARGOS SOUZA").cpf("16130312628").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ROBERTA RODRIGUES DE CAMARGOS SOUZA").cpf("01228141690").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ADILINA CRISTINA ALVES").cpf("88135993668").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("BENJAMIN ROCHA DOLABELA GOMES").cpf("16104928625").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("DENISE CRISTINA TEIXEIRA DA SILVEIRA").cpf("80962688649").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RICARDO ANTONIO DA SILVEIRA").cpf("76043975653").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("SAMUEL ELIAS ALVES QUIRINO").cpf("16917264601").celular("(31) 99528-3161").email("samueleliasalves8@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("RAQUEL OLIVEIRA SILVA").cpf("08953267609").celular("(31) 98341-7989").email("raqueloliveirabio@gmail.com").funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("OLÍVIA DE MALTA OLIVEIRA AUGUSTO").cpf("18281835630").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("LEONARDO ELIAS").cpf("07405860680").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("JESSICA GAMA BARBOSA COELHO").cpf("10901643602").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("FABIO DA SILVA COELHO").cpf("06326239699").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("MARCO TULIO").cpf("06704814671").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());
       members.add(Membro.builder().nome("ESTEVAO SOBRINHO TRINDADE").cpf("11887179607").celular(CELULAR_DEFAULT).email(EMAIL_DEFAULT).funcao(Funcao.Membro).build());

       return members;

    }


    private static void call(Contribuicao request) {

        System.out.println("CPF::" + request.getCpf());
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

    public static String resposta() {
        String resposta = "1) Resposta: Significado profético. \n" +
                "A) Cantares 1:6 – A igreja ficou responsável por cuidar da herança. \n" +
                "B) Cantares 1:15 – a igreja que vê com o olhar do Espírito Santo. \n" +
                "C) Cantares 2:2 – A igreja em santificação. \n" +
                "D) Cantares 2:12 – a voz do Espírito Santo. \n" +
                "E) Cantares 2:13 – O perfume dos dons espirituais na igreja.\n" +
                "\n" +
                "2) Resposta: significado profético. \n" +
                "A) Cantares 1:13 – Sofrimento da igreja por confessar a Jesus. \n" +
                "B) Cantares 1:14 – A operação do Espírito Santo na igreja gentílica. \n" +
                "C) Cantares 2:1 – o sangue de Jesus, o Seu Espírito Santo. \n" +
                "D) Cantares 2:3 – Jesus é único alimento para a igreja fiel. \n" +
                "E) Cantares 2:9 e 17– A pressa do Noivo em arrebatar a igreja fiel.\n" +
                "\n" +
                "3) Resposta: \n" +
                "A) A voz do Espírito Santo. \n" +
                "B) Ouvida na igreja fiel.\t\n" +
                "\n" +
                "4) Resposta: \n" +
                "A) Os dons espirituais. \n" +
                "B) A igreja fiel ouve a voz do Amado.";
        return resposta;
    }

    public static Contribuicao getContribuicaoComDenominacao(String nome, String cpf, String celular, String email, Funcao funcao, Denominacao denominacao) {
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
                    .contribuicao(resposta())
                    .denominacao_id(denominacao.getCodigo())
                .build();
    }

    public static Contribuicao getContribuicao(String nome, String cpf, String celular, String email, Funcao funcao) {
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
                .contribuicao(resposta())
                .build();
    }

}
