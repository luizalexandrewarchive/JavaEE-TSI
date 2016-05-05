package br.com.filtro;

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

import br.com.servlet.Validacao;

@WebFilter(filterName="FiltroLogado", urlPatterns={"/AdminSession","/LoginSession"})
public class FiltroLogado implements Filter {

	public FiltroLogado() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String usuario = (String) session.getAttribute("nome");
		String senha = (String) session.getAttribute("senha");

		boolean validacao = Validacao.loginCheck(usuario, senha);

		if(req.getServletPath().toString().equals("/LoginSession") && validacao == true){
			
			System.out.println("[LOG]: Acessando Login, mas já logado. Redirecionando...");
			rep.sendRedirect("AdminSession");

		}else if(req.getServletPath().toString().equals("/LoginSession")){
			
			chain.doFilter(request, response);

		}else if (validacao) {

			System.out.println("[LOG]: Acessando Administracao...");
			chain.doFilter(request, response);

		} else {

			System.out.println("[LOG]: Acessando Administracao, mas não logado...Redirecionando para Login");
			rep.sendRedirect("AcessoNegado");
		}
		
		
		
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
