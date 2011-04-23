<div class="box_titulo">
<h3 class="titulo_rotulo">Criar Equipamento </h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<tg:aviso/>
<form action="executa">
	<input type="hidden" name="operacao" value="GravaEquipamento">
	<div class="box">
	<input type="hidden" name="id" value="${equipamento.id}"/>	
	<p><tg:campoTexto label="Descrição" nameInput="descricao" idInput="descricao" 
				value="${equipamento.descricao}"/></p>

 	<p>
 		<Label class="rotulo">Marca</Label>  
 		<select class="lista" name="marca" id="divMarca" onchange="selecionaModelos()">
 			<c:forEach items="${listaMarca}" var="marca">
 				<c:choose>
 					<c:when test="${equipamento.marca.nome eq marca.nome}">
 						<option value=${marca.id} selected="selected">${marca.nome}</option>
 						<script>
 							selecionaModelos();
 						</script>
 					</c:when>
 					<c:otherwise>
 						<option value=${marca.id}>${marca.nome}</option>
 					</c:otherwise>
 				</c:choose>	
 			</c:forEach>	
 		</select>
 	</p> 
 	
	<p><Label class="rotulo">Modelo</Label><select class="lista" id="divModelo" name="modelo"></select></p> 
	
	<p><tg:campoTexto label="Num. Serie" nameInput="numeroSerie" idInput="numeroSerie" 
			value="${equipamento.numeroSerie}"/></p>
	<p><tg:campoTexto label="Patrimonio" nameInput="patrimonio" idInput="patrimonio"
			value="${equipamento.patrimonio}"/></p>
	
	<p>
 		<Label class="rotulo">Cliente</Label>  
 		<select class="lista" id="divCliente" name="cliente">
 			<c:forEach items="${listaCliente}" var="cliente">
 				<!--  seleciona cliente no combo -->
 				<c:choose>
 					<c:when test="${cliente.nome eq equipamento.cliente.nome}">
 						<option value=${cliente.id} selected>${cliente.nome}</option>
 					</c:when>
 					<c:otherwise>
 						<option value=${cliente.id}>${cliente.nome}</option>
 					</c:otherwise>
 				</c:choose>
 			</c:forEach>	
 		</select>
 	</p> 
 			
			
	</div>
	<div class="box_botao">
	<input class="botao_cria" type="submit"  value="Cria"/>
	<a class="link_pesquisa" href="pesquisa/equipamento_pg.jsp"/>Pesquisa</a>
	</div>
</form>
