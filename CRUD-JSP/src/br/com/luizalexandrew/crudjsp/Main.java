package br.com.luizalexandrew.crudjsp;

import java.sql.SQLException;

import br.com.luizalexandrew.crudjsp.Model.Usuario;
import br.com.luizalexandrew.crudjsp.ModelDao.UsuarioDao;

public class Main {

	public static void main(String[] args) throws SQLException {
//			
//		Usuario user = new Usuario(5, "odin", "775.856.326-11", "odin-apple@mac.com");
//		
//		UsuarioDao userDao = new UsuarioDao();
//		
//		userDao.adiciona(user);
		
		
//		Usuario user = new Usuario(2, "Tio Linus", "524.526.859-77", "tio-linus@linux.com");
//		
//		UsuarioDao userDao = new UsuarioDao();
//		
//		userDao.atualizar(user);
		
//		
//		Usuario user = new Usuario(5, "odin", "775.856.326-11", "odin-apple@mac.com");
//	
//		UsuarioDao userDao = new UsuarioDao();
//	
//		userDao.remove(user);
//		
		
		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.recuperarUsuario(1);
		
		System.out.println(user.getNome() + " - " + user.getEmail() + " - " + user.getCpf());
		
//		UsuarioDao userDao = new UsuarioDao();
//		ResultSet user = userDao.recuperarAll();
//		
//		while(user.next()){
//			System.out.println(user.getString("email"));
//		}
		
	}
}
