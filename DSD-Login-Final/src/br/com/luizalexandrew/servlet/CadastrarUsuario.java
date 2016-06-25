package br.com.luizalexandrew.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luizalexandrew.bo.UsuarioBO;
import br.com.luizalexandrew.model.Usuario;



@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarUsuario() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Cadastro.jsp");	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println(request.getParameter("nome"));
//		response.sendRedirect("Cadastro.jsp");
		
		
		Usuario user = new Usuario(request.getParameter("nome"), request.getParameter("email"), request.getParameter("usuario"), request.getParameter("senha"));
		
		boolean resultado = UsuarioBO.adicionar(user);
		
		if(resultado){
			response.sendRedirect("CadastroSucesso.jsp");
		}else{
			request.setAttribute("erroCadastro", "Erro ao cadastrar usuário, tente novamente.");
			
			RequestDispatcher rd=request.getRequestDispatcher("Cadastro.jsp");
		     rd.forward(request,response);
		}
	}

}
