package br.com.luizalexandrew.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.luizalexandrew.dao.UsuarioDao;
import br.com.luizalexandrew.model.Usuario;

@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginUsuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.validarUsuario(request.getParameter("usuario"), request.getParameter("senha"));
		
		if(user != null){
			HttpSession session = request.getSession(true);
			session.setAttribute("logado", "OK");
			session.setAttribute("id", user.getId());
			session.setAttribute("nome", user.getNome());
			session.setAttribute("usuario", user.getUsuario());			
			session.setAttribute("email", user.getEmail());
			response.sendRedirect("Administracao.jsp");
			
		}else{
			System.out.println("erro no login");		

			request.setAttribute("erroLogin", "Usuário ou senha incorreto");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		     rd.forward(request,response);
		}
	}

}
