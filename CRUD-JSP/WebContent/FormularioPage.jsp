<jsp:useBean id="usuarioBean" class="br.com.luizalexandrew.crudjsp.Model.Usuario" scope="page"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>




<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CRUD JSP</title>
</head>
<body>
<!--
	<h1>
		Valor: <jsp:getProperty property="nome" name="usuarioBean"/>
	</h1>
-->
	<h1>CRUD JSP</h1>
	<h2>Usuários</h2>
	<table border="1">
		<tr>	
			<td>ID</td>
			<td>Nome</td>
			<td>CPF</td>
			<td>E-mail</td>
		</tr>	
	</table>
	


</body>
</html>