package br.com.servlet;

public class Validacao {
	
	public static boolean loginCheck(String usuario, String senha) throws NullPointerException{
		try {
			return usuario.equals("luiz") && senha.equals("windows");
		} catch (Exception e) {
			return false;
		}
	}

}
