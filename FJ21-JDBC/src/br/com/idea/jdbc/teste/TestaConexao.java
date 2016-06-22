package br.com.idea.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.idea.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta com o banco.");
		connection.close();

	}

}
