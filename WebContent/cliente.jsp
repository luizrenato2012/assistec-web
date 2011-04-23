
<div class="box_titulo">
<h3 class="titulo_rotulo">Criar Cliente</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="assistec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<tg:aviso/>
<form action="executa">
	<input type="hidden" name="operacao" value="GravaCliente"/>
	<div class="box">	
	<input type="hidden" name="id" value="${cliente.id }"/>
	<p><assistec:campoTexto idInput="nome"      label="Nome"      nameInput="nome"      value="${cliente.nome}"/></p>
	<p><assistec:campoTexto idInput="endereco" label="Endereco" nameInput="endereco" value="${cliente.endereco}"/></p>
	<p><assistec:campoTexto idInput="cidade"     label="Cidade"      nameInput="cidade" 	   value="${cliente.cidade}"/></p>
	<p>
		<label for="uf" class="rotulo">UF</label>
		<select id="uf" name="uf" class="lista">
		<c:forEach items="${listUf}" var="uf">
			<c:choose>
				<c:when test="${cliente.uf eq uf}">
					<option value="${uf }" selected>${uf}</option>
				</c:when>
				<c:otherwise>
					<option value="${uf }">${uf}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</select>
	</p>	
	<p><assistec:campoTexto idInput="telefone" label="Telefone" nameInput="telefone" value="${cliente.telefone}"/></p>
	</div>
	<div class="box_botao">
	<input class="botao_cria" type="submit"  value="Grava"/>
	<a class="link_pesquisa" href="pesquisa/cliente_pg.jsp"/>Pesquisa</a>
	</div>
</form>
