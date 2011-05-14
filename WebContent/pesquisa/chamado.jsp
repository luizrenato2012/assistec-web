<div class="box_titulo">
<h3 class="titulo_rotulo">Pesquisar Chamado por</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="assistec" %>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<tg:aviso/>
<form action="<c:url value="${applicationContext}/executa"/>">
	<input type="hidden" name="operacao" value="PesquisaChamado"/>
	<div class="box">	
	<p>
	<select name="tipoArgumento" id="tipoArgumento" class="rotulo">
		<option value="id">ID</option>
		<option value="dataHoraAbertura">Data</option>
		<option value="numeroSerie">Num. S&eacute;rie</option>
		<option value="patrimonio">Patrimonio</option>
		<option value="cliente">Cliente</option>
	</select>
	<input type="text" name="argumento" class="texto" maxlength="10" onkeypress="formataDataHora(event,this)"/>
	</p>
	<c:set var="viewArg" value="${controlArg}" scope="page"/>
	</div>
	<div class="box_botao">
		<input class="botao_pesquisa" type="submit"  value="Pesquisa"/>
		<a class="link_pesquisa" href="<c:url value='${applicationContext}/chamado_pg.jsp'/>"/>Voltar</a>
	</div>
	<br/>

<c:if test="${not empty listaChamado}">
	<table>
	<th>ID</th>
	<th>Data/Hora</th><th>Cliente</th><th>Marca</th><th>Modelo</th><th>No Serie</th><th>Situacao</th>
 <c:forEach items="${listaChamado}" var="chamado">
	 	<tr>
	        <td>${chamado.id}</td> 
	        <td><fmt:formatDate  pattern="dd/MM/yyyy HH:mm" value="${chamado.dataHoraAbertura}"/>  </td>
			<td>${chamado.cliente.nome}</td>
			<td>${chamado.equipamento.marca.nome}</td>
			<td>${chamado.equipamento.modelo.descricao}</td>
			<td>${chamado.equipamento.numeroSerie}</td>
			<c:choose>
				<c:when test="${chamado.aberto}">
					<td>ABERTO</td>
				</c:when>
				<c:otherwise>
					<td>FECHADO</td>
				</c:otherwise>
			</c:choose>	
		</tr> 
	</c:forEach> 
	</table> 
</c:if>
</form>  
