<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Cadastro de EquipamentosS</title>
	<link rel="stylesheet" type="text/css" href="css/form.css" />
	<link rel="stylesheet" type="text/css" href="css/menu.css" />
	
 	<script type='text/javascript' src='dwr/interface/MarcaFacadeAjax.js'></script>
  	<script type='text/javascript' src='dwr/engine.js'></script>
  	<script type='text/javascript' src='dwr/util.js'></script>
	<script type='text/javascript' src='js/select.js'></script> 
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
<div class="linha_header">
<jsp:include page="header.jsp"/>
</div> -->
<div class="logo"></div>

<div class="coluna_menu">
<jsp:include page="menu.jsp"/>
</div>

<div class="coluna_body">
<%@ include file="equipamento.jsp"  %>
</div>
</body>
</html>
