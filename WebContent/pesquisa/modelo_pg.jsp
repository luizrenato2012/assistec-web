<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Pesquisa de Modelos</title>
<link rel="stylesheet" type="text/css" href="<c:url value="${applicationContext}/css/form.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="${applicationContext}/css/menu.css"/>" />
</head>
<body>

<div class="logo"></div>
<div class="coluna_menu">
<jsp:include page="../menu.jsp"/>
</div>

<div class="coluna_body">
<jsp:include page="/pesquisa/modelo.jsp"/>
</div>
</body>
</html>
