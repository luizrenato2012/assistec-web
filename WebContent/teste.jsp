<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
</head>
<body>
<%@tagliburi="http://java.sun.com/jsp/jstl/core"prefix="c"%>
<script type="text/javascript">
	function exibeMsg(){
		$('#mensagem').load("<c:url value='/TesteServlet'/>");
			docume
		}
</script>
<h3>Titulo</h3>

<div id="mensagem">
<h4>${msgAviso}</h4>
</div>
<a href="#" onclick="exibeMsg();">Teste</a>

</body>
</html>