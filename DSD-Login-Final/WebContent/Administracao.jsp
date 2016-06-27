<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/loginFinalDPD" user="root" password="windows" scope="session" />

	<h1>Administração</h1>
	
	<sql:query var="ResultadoUsuarios" dataSource="${ds}">
	    SELECT id,nome,email,usuario FROM loginFinalDPD.usuarios
	</sql:query>
	
	<table border="1">
		<tr>	
			<th>Nome</th>
			<th>Email</th>
			<th>Usuario</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
	 	<c:forEach var="listaUsuarios" items="${ResultadoUsuarios.rows}">
			<tr>                   
				<td><c:out value="${listaUsuarios.nome}"/></td>
	            <td><c:out value="${listaUsuarios.email}"/></td>
				<td><c:out value="${listaUsuarios.usuario}"/></td>
	            <td>
					<form action="AlterarUsuario" method="post">
		    			<input type="hidden" name="idalterar" value="<c:out value="${listaUsuarios.id}"/>" />
		    			<button>Alterar</button>
					</form>
				</td>
				<td>
					<form action="ExcluirUsuario" method="post">
		    			<input type="hidden" name="idexcluir" value="<c:out value="${listaUsuarios.id}"/>" />
		    			<button>Excluir</button>
					</form>
				</td>

			</tr>
	     </c:forEach>
	</table>
	<a href="Logout"><p>Logout</p></a>
