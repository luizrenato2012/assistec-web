<div class="box_titulo">
<h3 class="titulo_rotulo">Pesquisar Marcas</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="assistec" %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<tg:aviso/>
<form action="<c:url value="${applicationContext}/executa"/>">
	<input type="hidden" name="operacao" value="PesquisaMarca"/>
	<div class="box">	
	<p><assistec:campoTexto idInput="nome" label="Nome" nameInput="nome"/></p>
	<c:set var="viewArg" value="${controlArg}" scope="page"/>
	</div>
	<input type="hidden" name="operacao" value="PesquisaMarca">
	<div class="box_botao">
		<input class="botao_pesquisa" type="submit"  value="Pesquisa"/>
		<a class="link_pesquisa" href="<c:url value='${applicationContext}/marca_pg.jsp'/>"/>Voltar</a>
	</div>
	
	
<c:if test="${not empty itens}">
<table>
<th>Excluir</th><th>Descrição</th>
<c:forEach items="${itens}" var="marca">
<tr>
	<c:url value ='${applicationContext}/img/delete.png' var="img_delete"/>
	<td><a href="<c:url value='executa?operacao=ExcluiMarca&id=${marca.id}&viewArg=${viewArg}'/>"><img title="Exlcui ${marca.nome}" src="${img_delete}"/></a></td>
	<td><a title="Edita ${marca.nome}" href="<c:url value='executa?operacao=EditaMarca&id=${marca.id}'/>">${marca.nome}</a></td>  
</tr>
</c:forEach>
</table>
</c:if>
</form>  
