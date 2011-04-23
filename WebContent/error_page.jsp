<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>P&aacute;gina de Erro</title>
	<link rel="stylesheet" type="text/css"  href="css/menu.css"/>
</head>
<body>
<!-- 
<div class="linha_header">
	<jsp:include page="header.jsp"/>
</div>
-->
<div class="logo"></div>
<div class="coluna_body">
	<h3>Ocorreu um erro:</h3>
	<h4>${pageContext.exception}</h4> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	<a href="<c:url value='index.jsp'/>"> P&aacute;gina Inicial</a>
</div>
</body>
</html>