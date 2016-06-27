<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<c:choose>
	<c:when test="${not empty param.idalterar}">
		<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/loginFinalDPD" user="root" password="windows" scope="session" />
		
		<sql:query var="ResultadoUsuarios" dataSource="${ds}">
		    SELECT id,nome,email,usuario FROM loginFinalDPD.usuarios WHERE id=${param.idalterar}
		</sql:query>
	
		<h1>Alterar Usuario</h1>
		
		<c:forEach var="listaUsuarios" items="${ResultadoUsuarios.rows}">
			<form action="AlterarUsuario" method="post">
				<input type="hidden" name="id" value="${listaUsuarios.id}"/>
				<label>Nome:</label>
				<input type="text" name="nome" value="${listaUsuarios.nome}" required/><br>
				<label>E-mail:</label>
				<input type="email" name="email" value="${listaUsuarios.email}" required/><br> 
				<label>Usuario:</label>
				<input type="text" name="usuario" value="${listaUsuarios.usuario}" required/><br>
				<br>
				<input type="submit" value="Alterar">
			</form>
			<br>
			<a href="Administracao.jsp"><button>Cancelar</button></a>
		</c:forEach>		
	</c:when>

	<c:when test="${empty param.idalterar}">
		<c:redirect url="/Administracao.jsp"/>
	</c:when>
	
</c:choose>
	