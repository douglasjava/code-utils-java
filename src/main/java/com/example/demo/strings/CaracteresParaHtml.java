package com.example.demo.strings;

import java.io.UnsupportedEncodingException;

import org.apache.commons.text.StringEscapeUtils;

public class CaracteresParaHtml {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String testeCaracateres = "<p>Documento sem título <img src=\"http://agencia.elektro.com.br/imagens/03072020_topo.jpg\" height=\"424\" width=\"700\">&nbsp;Agora você pode efetuar o pagamento da sua fatura de energia por</p><p>meio do cartão virtual Caixa Elo (Auxílio Emergecial).</p><p>Para efetuar a operação, utilize a geração do cartão de débito virtual</p><p>pelo internet banking* e pague pela plataforma Flexpag.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://agencia.elektro.com.br/imagens/09062020_space.png\" height=\"10\" width=\"48\"><img src=\"http://agencia.elektro.com.br/imagens/03072020_video.png\" height=\"97\" width=\"164\">Para ver o passo a passo,</p><p>assista o vídeo <a href=\"https://www.gov.br/pt-br/noticias/financas-impostos-e-gestao-publica/2020/03/caixa-disponibiliza-cartao-de-debito-virtual-para-clientes\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(247, 210, 104);\"><strong>clique aqui</strong></a>.&nbsp;<img src=\"http://agencia.elektro.com.br/imagens/09062020_space.png\" height=\"10\" width=\"49\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Após a criação do cartão virtual,</p><p><a href=\"http://servicos.celpe.com.br/a-celpe/Paginas/pagamento-com-cartao-virtual-caixa-elo-auxilio-emergencial.aspx\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(247, 210, 104);\"><strong> clique aqui</strong></a> para acessar nosso site e selecione a opção</p><p><strong> Pagar faturas com o auxílio emergencial</strong>.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Atenção: A opção do Cartão Virtual Caixa Elo </strong></p><p><strong> (Auxílio Emergencial) só aparece depois que </strong></p><p><strong> o número do cartão for digitado.</strong></p><p><em>(*) A geração do cartão de débito ELO é feita pelo app da CAIXA.&nbsp;Serviço válido para correntistas da CAIXA.</em></p><p><img src=\"http://agencia.elektro.com.br/imagens/03072020_atencao.png\" height=\"142\" width=\"137\">&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"https://www.facebook.com/celpeoficial/\" rel=\"noopener noreferrer\" target=\"_blank\"><img src=\"http://agencia.elektro.com.br/imagens/03072020_facebook.png\" height=\"40\" width=\"40\"></a><a href=\"https://www.instagram.com/celpe_oficial/\" rel=\"noopener noreferrer\" target=\"_blank\"><img src=\"http://agencia.elektro.com.br/imagens/03072020_instagram.png\" height=\"40\" width=\"40\"></a><a href=\"https://twitter.com/OficialCelpe\" rel=\"noopener noreferrer\" target=\"_blank\"><img src=\"http://agencia.elektro.com.br/imagens/03072020_twitter.png\" height=\"40\" width=\"40\"></a>&nbsp;&nbsp;<img src=\"http://agencia.elektro.com.br/imagens/03072020_celpe.png\" height=\"70\" width=\"192\">&nbsp;&nbsp;</p>";
		System.out.println(testeCaracateres);

//		String convertido = StringEscapeUtils.escapeHtml4(testeCaracateres);

		String convertido2 = StringConverter.encodeHtml(testeCaracateres);


		System.out.println(convertido2);

	}

}
