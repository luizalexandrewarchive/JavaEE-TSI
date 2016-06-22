<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Funcions</h1>
	
	<form action="Functions.jsp" method="post">
		<label>Nome:</label>
		<input type="text" name="nome" required/><br>
		<label>E-mail:</label>
		<input type="email" name="email" required/><br> 
		<br>
		<input type="submit" value=Enviar>
	</form>
	<br>
	
	<h3>Parametros: ${fn:length(param)}</h3>
	<h4>Nome: ${param.nome}</h4>
	<h4>Email: ${param.email}</h4>
	
	<p>Nome Lenght: ${fn:length(param.nome)}</p>
	<p>Email Lenght: ${fn:length(param.email)}</p>
	<p>Email Contains "live.com": ${fn:contains(param.email, 'live.com')}</p>
	<p>Email ContainsIgnoteCase "live.com": ${fn:containsIgnoreCase(param.email, 'live.com')}</p>
	<p>Email Ends With ".com": ${fn:endsWith(param.email, '.com')}</p>
	<p>Email Ends With ".com.br": ${fn:endsWith(param.email, '.com.br')}</p>
	
	
	<c:set var="nome" value="${param.nome}"/>
	<c:set var="email" value="${param.email}"/>
	<p>nome var (1) : ${nome}</p>
	<p>email var (2) : ${email}</p>
	
	<p>Index of '@' (1) : ${fn:indexOf(email, "@")}</p>
	
	<p>Substituir email 'live' por 'gmail' : ${fn:replace(email, 'live', 'gmail')}</p>
	
	<p>Substring '5' a '14': ${fn:substring(email, 5, 14)}</p>
	
	<c:set var="nomeLowerCase" value="${fn:toLowerCase(nome)}" />
	<p>Nome to LowerCase: ${nomeLowerCase}</p>
	<c:set var="nomeUpperCase" value="${fn:toUpperCase(nome)}" />
	<p>Nome to UpperCase: ${nomeUpperCase}</p>
	
</body>
</html>