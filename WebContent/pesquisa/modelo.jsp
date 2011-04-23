<div class="box_titulo">
<h3 class="titulo_rotulo">Pesquisar Modelos</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="assistec" %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<tg:aviso/>
<form action="<c:url value="${applicationContext}/executa"/>">
	<input type="hidden" name="operacao" value="PesquisaModelo"/>
	<div class="box">	
		<p><assistec:campoTexto idInput="descricao" label="Descrição" nameInput="descricao"/></p>
		<c:set var="viewArg" value="${controlArg}" scope="page"/>
	</div>
	<div class="box_botao">
		<input class="botao_pesquisa" type="submit"  value="Pesquisa"/>
		<a class="link_pesquisa" href="<c:url value='${applicationContext}/executa?operacao=ExibeModelo'/>"/>Voltar</a>
	</div>
	
<c:if test="${not empty itens}">
<table>
<tr><th></th><th>Descrição</th> <th>Marca</th></tr>
<c:forEach items="${itens}" var="modelo">
<tr>
	<c:url value="${applicationContext}/img/delete.png" var="delele_img"/>
	<td><a href="<c:url value='executa?operacao=ExcluiModelo&id=${modelo.id}&viewArg=${viewArg}'/>"><img src="${delele_img}"></a></td>
	<td><a href="<c:url value='executa?operacao=EditaModelo&id=${modelo.id}'/>">${modelo.descricao}</a></td>
	<td>${modelo.marca.nome}</td>
</tr>
</c:forEach>
</table>
</c:if>
</form>  
