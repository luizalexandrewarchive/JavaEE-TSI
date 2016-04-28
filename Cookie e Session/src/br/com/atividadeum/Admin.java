package br.com.atividadeum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		boolean verificado;
		String usuario = "";
		String senha = "";

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().compareTo("usuario") == 0) {
					usuario = cookie.getValue();
				}
				if (cookie.getName().compareTo("senha") == 0) {
					senha = cookie.getValue();
				}
			}

			verificado = Validacao.loginCheck(usuario, senha);

			if (verificado == true) {
				Enviar.adminPage(response, usuario);
			} else {
				response.sendRedirect(request.getContextPath());
			}
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}
}
