package br.com.luizalexandrew.crudjsp.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	
	private static Connection connection;	
		
	public static Connection getConnection(){
		
		String driverName = "com.mysql.jdbc.Driver";
		
		if(connection == null){
			
			try{
				Class.forName(driverName);
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/crudjsp", "root", "windows");
				System.out.println("Sucesso ao fazer a conexão com o banco");
			}catch (ClassNotFoundException | SQLException e){
				System.out.println("Falha na conexão com o banco");			
			}
		}
		return connection;
			
	}
	
	
	

}
