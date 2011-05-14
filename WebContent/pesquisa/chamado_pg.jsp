<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Pesquisa de Chamados</title>
<link rel="stylesheet" type="text/css" href="<c:url value="${applicationContext}/css/form.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="${applicationContext}/css/menu.css"/>" />

 <!-- formatacao ao digitar dd/MM/aaaa HH:mm -->
	<script>
		function formataDataHora(evento, objeto){
			if (tipoArgumento.value != 'dataHoraAbertura') {
				return;
			}
			
			var keypress=(window.event)?event.keyCode:evento.which;
			campo = eval (objeto);
			if (campo.value == '00/00/0000 00:00:00') 		{
				campo.value=""
			}

			caracteres = '0123456789';
			separacao1 = '/';
			separacao2 = ' ';
			separacao3 = ':';
			conjunto1 = 2;
			conjunto2 = 5;
			conjunto3 = 10;
			conjunto4 = 13;
			conjunto5 = 16;
			/** 11/11/1111 11:11 */
			if ((caracteres.search(String.fromCharCode (keypress))!=-1) && campo.value.length < (17)) 	{
			if (campo.value.length == conjunto1 )
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto2)
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto3)
			campo.value = campo.value + separacao2;
			else if (campo.value.length == conjunto4)
			campo.value = campo.value + separacao3;
			else if (campo.value.length == conjunto5)
			campo.value = campo.value;
			}
			else
				event.returnValue = false;
			}
		</script>
</head>
<body>

<div class="logo"></div>
<div class="coluna_menu">
	<jsp:include page="../menu.jsp"/>
</div>
<div class="coluna_body">
	<jsp:include page="/pesquisa/chamado.jsp"/>
</div>
</body>
</html>
