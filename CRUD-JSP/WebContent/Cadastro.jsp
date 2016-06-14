<%@page import="br.com.luizalexandrew.crudjsp.Model.Usuario"%>

<jsp:useBean id="usuarioBean"
	class="br.com.luizalexandrew.crudjsp.Model.Usuario" scope="page"/>
	

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:setProperty property="*" name="usuarioBean" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CRUD</title>
	</head>
	<body>
	
		<%
			if(request.getMethod().equalsIgnoreCase("POST")){
				
				if(request.getParameter("cadastrar") != null){
					usuarioBean.cadastrar();
					response.sendRedirect("Cadastro.jsp");
				}
				
				if(request.getParameter("change") != null){
					System.out.println(usuarioBean.getId());
					usuarioBean.atualizar();
				
				}
			}
		
			if(request.getParameter("excluir") != null){
				usuarioBean.excluir(request.getParameter("excluir"));
				response.sendRedirect("Cadastro.jsp");
			}
		%>
	
		<form action="Cadastro.jsp" method="post">
			<input type="hidden" name="cadastrar" value="true">
			<label>Nome:</label>
			<input type="text" name="nome" /><br>
			<label>E-mail:</label>
			<input type="text" name="email" /><br> 
			<label>CPF:</label>
			<input	type="text" name="cpf" /><br>
			<br>
			<input type="submit"	value="Cadastrar">
		</form>
	
		<br>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>CPF</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
			<%
				for(Usuario user: usuarioBean.recuperarAll()){	
			%>
			<tr>
				<td><%out.println(user.getId()); %></td>
				<td><%out.println(user.getNome()); %></td>
				<td><%out.println(user.getEmail()); %></td>
				<td><%out.println(user.getCpf()); %></td>
				<td>
				<form action="Cadastro.jsp" method="post">
	    			<input type="hidden" name="alterar" value="<%=user.getId()%>" />
	    			<button>Alterar</button>
				</form>
				</td>
				
				<td>
				<form action="Cadastro.jsp" method="post">
	    			<input type="hidden" name="excluir" value="<%=user.getId()%>" />
	    			<button>Excluir</button>
				</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		
		<%
				
		if(request.getParameter("alterar") != null){
			Usuario usuarioAltera = usuarioBean.recuperarUser(request.getParameter("alterar"));
			
			%>
				<br>
				<form action="Cadastro.jsp" method="post">
					<input type="hidden" name="change" value="true">
					<label>ID: <%=usuarioAltera.getId()%></label>
					<input type="hidden" name="id" value="<%=usuarioAltera.getId()%>"><br>
					<label>Nome:</label>
					<input type="text" name="nome" value="<%=usuarioAltera.getNome()%>"/><br>
					<label>E-mail:</label>
					<input type="text" name="email" value="<%=usuarioAltera.getEmail()%>"/><br> 
					<label>CPF:</label>
					<input	type="text" name="cpf" value="<%=usuarioAltera.getCpf()%>"/><br> 
					<input type="submit" value="Alterar">
				</form>
				
			<%
		}
			%>
	</body>
</html>