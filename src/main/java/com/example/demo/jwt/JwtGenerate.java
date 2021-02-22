package com.example.demo.jwt;

/**
 * Token JWT é formado por HEADER . PAYLOAD . ASSINATURA Não devem contém
 * informações sigilosas, pois nesse exemplo essas informações estão apenas
 * encodadas e não criptografadas Existe a opção de usar a especificação JOSE
 * JWE que o payload é criptografado
 * 
 * @apiNote JOSE -> Javascript Object Signing and Encryption
 *          {@link https://jose.readthedocs.io/en/latest/}
 * @apiNote JWS -> JWT assinado
 * @apiNote JWA -> Tipos de algoritmos nesse caso foi usado o HS256
 * @apiNote JWE -> PayLoad Criptografado
 *
 * @author Marques
 *
 */
public class JwtGenerate {

	public static void main(String[] args) {

		String header = "{ \"alg\": \"HS256\" }";

		String payload = "{ \"dias:nome\": \"Douglas\", \"dias:admin\": true }";

		String secret = "#$%DOl95*-!#Dc";

		String encodedData = Base64Url.encode(header) + "." + Base64Url.encode(payload);

		String signature = HmacSha256.sign(secret, encodedData);

		String jwt = encodedData + "." + signature;

		System.out.println(jwt);

	}

}
