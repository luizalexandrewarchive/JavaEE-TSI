package br.com.atividadeum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCookie")
public class LoginCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCookie() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		Enviar.login(response, false);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		if (Validacao.loginCheck(usuario, senha)) {
			Cookie usuarioCookie = new Cookie("usuario", usuario);
			Cookie passwordCookie = new Cookie("senha", senha);
			response.addCookie(usuarioCookie);
			response.addCookie(passwordCookie);
			response.sendRedirect("Admin");
		} else {
			Enviar.login(response, true);
		}
		
	}
}
