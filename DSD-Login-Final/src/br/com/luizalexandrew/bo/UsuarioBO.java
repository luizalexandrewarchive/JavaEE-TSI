package br.com.luizalexandrew.bo;

import br.com.luizalexandrew.dao.UsuarioDao;
import br.com.luizalexandrew.model.Usuario;

public class UsuarioBO {

	public static boolean adicionar(Usuario user){		
		if(user.getNome() != "" && user.getEmail() != "" && user.getUsuario() != "" && user.getSenha() != ""){
			UsuarioDao userDao = new UsuarioDao();			
			return userDao.adicionar(user);
		}else{			
			return false;
		}
	}
	
	public static boolean alterar(Usuario user){	
		if(user.getId() != 0 && user.getNome() != "" && user.getEmail() != "" && user.getUsuario() != ""){
			UsuarioDao userDao = new UsuarioDao();			
			return userDao.atualizar(user);
		}else{
			return false;
		}
	}
}
