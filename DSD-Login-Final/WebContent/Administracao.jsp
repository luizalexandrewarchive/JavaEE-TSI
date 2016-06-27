<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

	<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/loginFinalDPD" user="root" password="windows" scope="session" />

	<h1>Administração</h1>
	<p><c:out value="Nome: ${sessionScope.nome}"/></p>
	<p><c:out value="Usuario: ${sessionScope.usuario}"/></p>
	<a href="Logout"><button>Logout</button></a><br>
	<br>
		
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
				<td>${listaUsuarios.nome}</td>
	            <td>${listaUsuarios.email}</td>
				<td>${listaUsuarios.usuario}</td>
	            <td>
					<form action="AlterarUsuario.jsp" method="post">
		    			<input type="hidden" name="idalterar" value="${listaUsuarios.id}" />
		    			<button>Alterar</button>
					</form>
				</td>
				<td>
					<form action="ExcluirUsuario" method="post">
		    			<input type="hidden" name="idexcluir" value="${listaUsuarios.id}" />
		    			<button>Excluir</button>
					</form>
				</td>
			</tr>
	     </c:forEach>
	</table>
	
	<c:if test="${not empty erroAlterar}">
    	<p>${erroAlterar}</p>
    </c:if>
    <br>
    <a href="Cadastro.jsp"><button>Cadastrar</button></a><br>
    <br>   

