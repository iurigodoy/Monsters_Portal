package br.com.monster.portal.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class crypt {
	
	public String criptografar(String original) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		return senha;
	}
}
