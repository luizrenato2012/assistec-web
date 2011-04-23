<div class="box_titulo">
<h3 class="titulo_rotulo">Pesquisar Cliente</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="assistec" %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<tg:aviso/>
<form action="<c:url value="${applicationContext}/executa"/>">
	<input type="hidden" name="operacao" value="PesquisaCliente"/>
	<div class="box">	
	<p><assistec:campoTexto idInput="nome" label="Nome" nameInput="nome"/></p>
	<c:set var="viewArg" value="${controlArg}" scope="page"/>
	</div>
	<input type="hidden" name="operacao" value="PesquisaCliente">
	<div class="box_botao">
		<input class="botao_pesquisa" type="submit"  value="Pesquisa"/>
		<a class="link_pesquisa" href="<c:url value='${applicationContext}/executa?operacao=ExibeCliente'/>"/>Voltar</a>
	</div>
	
	
<c:if test="${not empty itens}">
<table>
	<th>Nome</th><th>Endereço</th><th>Cidade</th><th>UF</th><th>Telefone</th>
	<c:forEach items="${itens}" var="cliente">
	<tr>
		<!-- <td><a title="Exclui ${cliente.nome}" href="<c:url value='executa?operacao=ExcluiCliente&id=${cliente.id}&viewArg=${viewArg}'/>">
			<img src="img/delete.png"/></a></td>  -->
		<td><a title="Edita ${cliente.nome}"href="<c:url value='executa?operacao=EditaCliente&id=${cliente.id}'/>">${cliente.nome}</a></td>
		<td>${cliente.endereco}</td><td>${cliente.cidade}</td><td>${cliente.uf}</td><td>${cliente.telefone}</td>
	</tr>
	</c:forEach>
</table>
</c:if>
</form>  
