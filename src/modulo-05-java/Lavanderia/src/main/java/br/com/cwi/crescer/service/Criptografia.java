package br.com.cwi.crescer.service;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class Criptografia {

	public static String criptografar(String texto){
		return new Md5PasswordEncoder().encodePassword(texto, null);
	}
}
