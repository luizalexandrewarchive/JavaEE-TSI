package br.com.luizalexandrew.crudjsp.ModelDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.luizalexandrew.crudjsp.Connection.ConnectionFactory;
import br.com.luizalexandrew.crudjsp.Model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	
	public UsuarioDao(){
		this.connection = ConnectionFactory.getConnection();
	}
	
	public Usuario recuperarUsuario(int id){
		
		Usuario user = null;
		String sql = "SELECT * FROM crudjsp.usuario " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);
	
			ResultSet resultado = stmt.executeQuery();
		
			while(resultado.next()){
				user = new Usuario(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"));
		    }
			
			System.out.println("Usuário Recuperado");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return user;		
	}
	
	
	public ResultSet recuperarAll(){
		ResultSet resultado = null;
		String sql = "SELECT * FROM crudjsp.usuario";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);
	
			resultado = stmt.executeQuery();

			System.out.println("Usuário Recuperado");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return resultado;		
	}
	
	
	public void adiciona(Usuario user){		
		String sql = "INSERT INTO crudjsp.usuario " + "(nome,cpf,email)" + " VALUES (?,?,?)";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getCpf());
			stmt.setString(3, user.getEmail());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Adicionado");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}
	
	public void atualizar(Usuario user){		
		String sql = "UPDATE crudjsp.usuario SET " + "id=?, nome=?, cpf=?, email=? " + "WHERE id=?";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getNome());
			stmt.setString(3, user.getCpf());
			stmt.setString(4, user.getEmail());
			stmt.setLong(5, user.getId());
			
			stmt.execute();
			stmt.close();
			System.out.println("Usuário Atualizado");
		}catch(SQLException e){
			System.out.println(e);
		}		
	}
	
	public void remove(Usuario user){		
		String sql = "DELETE FROM crudjsp.usuario " + "WHERE id=?";
		
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

}
