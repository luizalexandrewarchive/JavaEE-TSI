package br.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EnviarPage {

	public static void login(HttpServletResponse response, boolean withErrorMessage)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		out.println("<h1>Login</h1>");
		out.println("<form method='post' action='LoginSession'>");
		out.println("Nome Usuário:");
		out.println("<input type='text' name='usuario'/> <br>");
		out.println("Senha: ");
		out.println("<input type='password' name='senha'/>");
		if (withErrorMessage) {
			out.println("<p>Informações de Login inválidas</p>");
		}
		out.println("<input type='submit' value='Enviar'/>");

	}

	public static void adminPage(HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<a href=Logout><p>Sair</p></a>");
		out.println("<h1>Pagina de Administracao</h1>");
		out.println("Bem vindo Admin");

	}
}
