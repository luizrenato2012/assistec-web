<div class="box_menu">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  definido path da aplicacao p/ evitar erros ao chamar menu de form de pesquisa -->
<c:url value="${applicationContext}/" var="applicationPath"/>
<p><a class="titulo_rotulo" href="${applicationPath}executa?operacao=ExibeCliente">Clientes</a></p>
<p><a class="titulo_rotulo" href="${applicationPath}executa?operacao=ExibeEquipamento">Equipamentos</a></p>
<p><a class="titulo_rotulo" href="${applicationPath}marca_pg.jsp">Marcas</a></p>
<p><a class="titulo_rotulo" href="${applicationPath}executa?operacao=ExibeModelo">Modelos</a></p> 
<p><a class="titulo_rotulo" href="${applicationPath}chamado_pg.jsp">Chamados</a></p>
<p><a class="titulo_rotulo" href="${applicationPath}atendimento_pg.jsp">Atendimentos</a></p>
<p><a class="titulo_rotulo" href="${applicationPath}index.jsp">Home</a></p>
</div>