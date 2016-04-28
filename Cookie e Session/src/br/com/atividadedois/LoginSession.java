package br.com.atividadedois;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.atividadeum.Enviar;

@WebServlet("/LoginSession")
public class LoginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginSession() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enviar.login(response, false);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		boolean validacao = Validacao.loginCheck(usuario, senha);

		if (validacao) {
			HttpSession session = request.getSession(true);
			session.setAttribute("nome", usuario);
			session.setAttribute("senha", senha);
			response.sendRedirect("AdminSession");
		} else {
			Enviar.login(response, true);
		}

	}

}
