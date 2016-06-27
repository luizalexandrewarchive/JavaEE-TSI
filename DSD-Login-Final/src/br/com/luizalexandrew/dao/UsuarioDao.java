package br.com.luizalexandrew.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.luizalexandrew.connection.ConnectionFactory;
import br.com.luizalexandrew.model.Usuario;;

public class UsuarioDao {
	
	private Connection connection;
		
	public UsuarioDao(){
		this.connection = ConnectionFactory.getConnection();
	}
	
	public Usuario recuperarUsuario(int id){
		
		Usuario user = null;
		String sql = "SELECT * FROM loginFinalDPD.usuarios " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);
	
			ResultSet resultado = stmt.executeQuery();
		
			while(resultado.next()){
				user = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("usuario"), resultado.getString("senha"));
		    }
			
			System.out.println("Usuário Recuperado");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return user;		
	}
	
	public Usuario validarUsuario(String usuario, String senha){
		
		Usuario user = null;
		String sql = "SELECT * FROM loginFinalDPD.usuarios " + "WHERE usuario=? AND senha=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario);
			stmt.setString(2, senha);
	
			ResultSet resultado = stmt.executeQuery();
		
			while(resultado.next()){
				user = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("usuario"), resultado.getString("senha"));
		    }
			
			System.out.println("Usuário Recuperado");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return user;		
	}
	 
	
	public List<Usuario> getLista(){
		ResultSet resultado = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM loginFinalDPD.usuarios";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			resultado = stmt.executeQuery();

			System.out.println("Usuário Recuperado");
			 
			 while(resultado.next()){
				 Usuario usuario = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"), resultado.getString("usuario"), resultado.getString("senha"));
				 usuarios.add(usuario);
			 }			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
		return usuarios;		
	}
	
	
	public boolean adicionar(Usuario user){		
		String sql = "INSERT INTO loginFinalDPD.usuarios " + "(nome,email,usuario,senha)" + " VALUES (?,?,?,?)";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getUsuario());
			stmt.setString(4, user.getSenha());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Adicionado");
			return true;
		}catch(SQLException e){
			System.out.println(e);
		}
		return false;		
	}
	
	public void atualizar(Usuario user){		
		String sql = "UPDATE loginFinalDPD.usuarios SET " + "id=?, nome=?, email=?, usuario=?, senha=? " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getUsuario());
			stmt.setString(5, user.getSenha());
			stmt.setLong(6, user.getId());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Atualizado");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}
	
	public void remove(Usuario user){		
		String sql = "DELETE FROM loginFinalDPD.usuarios " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Removido");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}
	
	public void remove(String id){		
		String sql = "DELETE FROM loginFinalDPD.usuarios " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, Integer.parseInt(id));
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Removido");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}

}