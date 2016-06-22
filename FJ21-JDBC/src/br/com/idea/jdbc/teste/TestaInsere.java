package br.com.idea.jdbc.teste;

import java.util.Calendar;

import br.com.idea.jdbc.dao.ContatoDao;
import br.com.idea.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		contato.setNome("Hasp");
		contato.setEmail("hasp.dot@hotmail.com");
		contato.setEndereco("Br 153 Km 39 Morrinhos - GO");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		System.out.println("Contato Adicionado");	
	}

}
