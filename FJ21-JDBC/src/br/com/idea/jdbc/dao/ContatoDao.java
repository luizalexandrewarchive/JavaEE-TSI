package br.com.idea.jdbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;

import br.com.idea.jdbc.ConnectionFactory;
import br.com.idea.jdbc.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(){
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		
		String sql = "INSERT INTO contatos " + "(nome, email,endereco,dataNascimento)" + " VALUES (?,?,?,?)";
		
		try{
			
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, (java.sql.Date) new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}
	

}
