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

@WebServlet("/AlterarUsuario")
public class AlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Administracao.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario user = new Usuario(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"),
				request.getParameter("email"), request.getParameter("usuario"));

		boolean resultado = UsuarioBO.alterar(user);

		if (resultado) {
			response.sendRedirect("Administracao.jsp");
		} else {
			request.setAttribute("erroAlterar", "Erro ao alterar usuário, tente novamente.");
			RequestDispatcher rd = request.getRequestDispatcher("Administracao.jsp");
			rd.forward(request, response);
		}

	}
}
