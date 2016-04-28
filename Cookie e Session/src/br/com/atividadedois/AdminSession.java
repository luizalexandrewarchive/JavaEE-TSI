package br.com.atividadedois;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminSession")
public class AdminSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSession() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String usuario = (String) session.getAttribute("nome");
		String senha = (String) session.getAttribute("senha");

		boolean verificado = Validacao.loginCheck(usuario, senha);

		if (verificado == true) {
			EnviarPage.adminPage(response, usuario);
		} else {

			response.sendRedirect("LoginSession");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
