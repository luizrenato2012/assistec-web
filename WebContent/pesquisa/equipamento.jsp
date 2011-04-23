<div class="box_titulo">
<h3 class="titulo_rotulo">Pesquisar Equipamento por</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="assistec" %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<tg:aviso/>
<form action="<c:url value="${applicationContext}/executa"/>">
	<input type="hidden" name="operacao" value="PesquisaEquipamento"/>
	<div class="box">	
	<p>
	<select name="tipoArgumento" class="rotulo">
		<option value="descricao">Descri&ccedil;&atilde;o</option>
		<option value="marca">Marca</option>
		<option value="modelo">Modelo</option>
		<option value="numeroSerie">Num. S&eacute;rie</option>
		<option value="patrimonio">Patrimonio</option>
	</select>
	<input type="text" name="argumento" class="texto"/>
	</p>
	<c:set var="viewArg" value="${controlArg}" scope="page"/>
	</div>
	<div class="box_botao">
		<input class="botao_pesquisa" type="submit"  value="Pesquisa"/>
		<a class="link_pesquisa" href="<c:url value='${applicationContext}/equipamento_pg.jsp'/>"/>Voltar</a>
	</div>
	
	
<c:if test="${not empty listaEquipamento}">
	<table>
	<th>Descricao</th><th>Marca</th><th>Modelo</th><th>No Serie</th><th>Patrimonio</th> <th>Cliente</th>
	<c:forEach items="${listaEquipamento}" var="equipamento">
		<tr>
	      <!--   <td>
	        	<a href="<c:url value='executa?operacao=Exclui&id=${cliente.id}&viewArg=${viewArg}'/>">
	        		<c:url value='${applicationContext}/img/delete.png' var="img_url"/>
	        		<img  title="Exclui ${equipamento.descricao}" src="${img_url}"/></a>
	        </td> -->
		    <td><a title="Edita ${equipamento.descricao}" href="<c:url value='executa?operacao=EditaEquipamento&id=${equipamento.id}'/>">${equipamento.descricao}</a></td>
			<td>${equipamento.marca.nome}</td>
			<td>${equipamento.modelo.descricao}</td>
			<td>${equipamento.numeroSerie}</td>
			<td>${equipamento.patrimonio}</td>
			<td>${equipamento.cliente.nome}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</form>  
