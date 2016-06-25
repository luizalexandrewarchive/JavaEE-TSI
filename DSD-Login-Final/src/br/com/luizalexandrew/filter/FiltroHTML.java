package br.com.luizalexandrew.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FiltroHTML implements Filter {

    public FiltroHTML() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<title>DSD-Login</title>");
		out.println("</head>");
		out.println("<body>");		
		chain.doFilter(request, response);		
		out.println("</body>");
		out.println("</html>");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {		
		
	}
}