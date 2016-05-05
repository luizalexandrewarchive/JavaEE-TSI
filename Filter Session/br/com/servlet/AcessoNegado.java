package br.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AcessoNegado")
public class AcessoNegado extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AcessoNegado() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		out.println("<h1>Acesso Negado</h1>");
		out.println("<p>Faça Login para acessar essa pagina</p>");
		out.println("<a href='LoginSession'><p>Login</p></a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
