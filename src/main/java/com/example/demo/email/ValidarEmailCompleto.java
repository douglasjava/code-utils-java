package com.example.demo.email;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidarEmailCompleto {

	static Logger logger = LoggerFactory.getLogger(ValidarEmailCompleto.class);

	public static void main(String[] args) {
		
		String email = "douglas.dias@montreal.com.br";					
		
		try {			
			
			validarIntegridade(email);
			
			List<String> mxs = recuperarMx(email);
			
			validarMxs(mxs, "campanha@montreal.com.br", email);			
			
			logger.info("E-mail {} válido", email);
			
		} catch (Exception e) {
			logger.error("E-mail {} invalido - cause: [ {} ]", email, e.getMessage());
			
		}
		
		
	}

	private static void validarMxs(List<String> mxs, String remetente, String destinatario) {
		int codigoRetorno = 0;

		for (String addressMx : mxs) {

			try (Socket socket = new Socket(addressMx, 25)) {

				try (BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

					try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

						logger.info("validando header");
						codigoRetorno = lerBufferedReader(bReader);
						validarRetorno(codigoRetorno, CodigoRetornoSmtpEnum.STATUS_220, "Invalid header");

						logger.info("validando SMTP Estendido (ESMTP)");
						inserirNovoComando(bWriter, "HELO " + addressMx);
						codigoRetorno = lerBufferedReader(bReader);
						validarRetorno(codigoRetorno, CodigoRetornoSmtpEnum.STATUS_250, "Not ESMTP");
						
						logger.info("validando o endereço do remetente {}", remetente);
						inserirNovoComando(bWriter, "MAIL FROM: <" + remetente + ">");
						codigoRetorno = lerBufferedReader(bReader);
						validarRetorno(codigoRetorno, CodigoRetornoSmtpEnum.STATUS_250, "Sender rejected");
						
						logger.info("validando o email {}", destinatario);
						inserirNovoComando(bWriter, "RCPT TO: <" + destinatario + ">");
						codigoRetorno = lerBufferedReader(bReader);
						validarRetorno(codigoRetorno, CodigoRetornoSmtpEnum.STATUS_250, "Address is not valid!");						
						
						logger.info("Finalizando comando");
						inserirNovoComando(bWriter, "RSET");
						lerBufferedReader(bReader);
						inserirNovoComando(bWriter, "QUIT");
						lerBufferedReader(bReader);
					}

				}

			} catch (Exception e) {
				throw new IllegalArgumentException(e.getMessage());

			}

		}

	}

	private static void validarRetorno(int codigoRetorno, CodigoRetornoSmtpEnum codigoEsperado, String messagemErro) {
		if (codigoRetorno != codigoEsperado.getCode()) {
			throw new IllegalArgumentException(messagemErro);

		}

	}
	
	private static void inserirNovoComando(BufferedWriter bWriter, String text) throws IOException {
		bWriter.write(text + "\r\n");
		bWriter.flush();
	}

	private static int lerBufferedReader(BufferedReader bReader) throws IOException {
		String line = null;
		int res = 0;

		while ((line = bReader.readLine()) != null) {
			logger.info("saida comando [ {} ]", line);
			
			String pfx = line.substring(0, 3);

			try {
				res = Integer.parseInt(pfx);
			} catch (Exception ex) {
				res = -1;
			}

			if (line.charAt(3) != '-') {
				break;
			}

		}
		
		

		return res;

	}

	private static void validarIntegridade(String email) {
		int pos = recuperarPosicicaoArroba(email);

		if (pos == -1) {
			throw new IllegalArgumentException("E-mail fora do padrão");

		}

	}

	private static List<String> recuperarMx(String email) {
		int pos = recuperarPosicicaoArroba(email);
		String domain = email.substring(++pos);
		String[] mxs = RecuperarMx.getMX(domain);

		if (mxs.length == 0) {
			throw new IllegalArgumentException("E-mail invalido.");
		}

		return Arrays.asList(mxs);
	}

	private static int recuperarPosicicaoArroba(String email) {
		return email.indexOf('@');
	}

}
