package br.com.luizalexandrew.teste;

import br.com.luizalexandrew.dao.UsuarioDao;
import br.com.luizalexandrew.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario user = new Usuario(1, "Luiz Alexandre", "luiz.alexandre@live.com", "luizalexandrew", "windows");
		UsuarioDao userDao = new UsuarioDao();
		
		userDao.adicionar(user);
		

	}

}
