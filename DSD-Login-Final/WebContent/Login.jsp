<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


    <h2>Login</h2>
    
    <c:if test="${not empty erroLogin}">
    	<p>${erroLogin}</p>
    </c:if>
    
	<form action="LoginUsuario" method="post">

		<label>Usuario</label>
		<input type="text" name="usuario" required/><br> 
		<label>Senha:</label>
		<input type="password" name="senha" required/><br> 
		<br>
		<input type="submit" value="Entrar">
	</form>
    
    <a href="Cadastro.jsp"><p>Cadastrar</p></a>