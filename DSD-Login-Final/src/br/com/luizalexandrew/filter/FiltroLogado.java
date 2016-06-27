package br.com.luizalexandrew.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter(filterName="FiltroLogado", urlPatterns={"/Administracao.jsp", "/ExcluirUsuario"})
public class FiltroLogado implements Filter {

	public FiltroLogado() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		  
		try{
			if(session.getAttribute("logado") == "OK"){
				System.out.println("Usuario logado: " + session.getAttribute("nome"));
				chain.doFilter(request, response);
			}else{
				System.out.println("Usuario nao Logado3");
				rep.sendRedirect("Login.jsp");
			}
		}catch(Exception e){
			System.out.println("Usuario nao Logado2");
			rep.sendRedirect("Login.jsp");
		}

		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}