<div class="box_titulo">
<h3 class="titulo_rotulo">Criar Modelos</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tg:aviso/>
<body>

<form action="executa">
	<input type="hidden" name="operacao" value="GravaModelo"/>
	<input type="hidden" name="id" value="${modelo.id}">
	<div class="box">	
<p>	<tg:campoTexto label="Descrição" nameInput="descricao" idInput="descricao" value="${modelo.descricao}"/></p>
	<p><label class="rotulo">Marca</label>
	<!-- preenchimento do combo com marcas e selecionada a marca do modelo resultado da pesquisa -->
	<c:if test="${not empty marcas}">
		<select class="lista" name="marca">
		<!-- seleciona marca de um modelo quando for edição vinda da pesquisa -->
		<!-- se o marca do item corrente (que esta na iteracao) for igual a do modelo a ser exibido seleciona-->
		<c:forEach items="${marcas}" var="marcaIn">
			<c:choose>
			<c:when test="${modelo.marca.id eq marcaIn.id}">
				<option value="${marcaIn.id}" selected>${marcaIn.nome}</option>
			</c:when>
			<c:otherwise>
				<option value="${marcaIn.id}">${marcaIn.nome}</option>
			</c:otherwise>	
			</c:choose>
		</c:forEach>
		</select>
	</c:if> </p>
	</div>
	<div class="box_botao">
	<input class="botao_cria" type="submit"  value="Cria"/>
	<a class="link_pesquisa" href="pesquisa/modelo_pg.jsp"/>Pesquisa</a>
	</div>
</form>
