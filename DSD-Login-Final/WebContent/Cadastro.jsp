<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<h2>Cadastrar</h2>
	
	<c:if test="${not empty erroCadastro}">
    	<p>${erroCadastro}</p>
    </c:if>
	
	<form action="CadastrarUsuario" method="post">
		<label>Nome:</label>
		<input type="text" name="nome" required/><br>
		<label>E-mail:</label>
		<input type="email" name="email" required/><br> 
		<label>Usuario:</label>
		<input type="text" name="usuario" required/><br>
		<label>Senha:</label>
		<input type="password" name="senha" required/><br> 
		<br>
		<input type="submit" value="Cadastrar">
	</form>
	
	<a href="Login.jsp"><p>Fazer Login</p></a>
