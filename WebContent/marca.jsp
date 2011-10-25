
<div class="box_titulo">
	<h3 class="titulo_rotulo">Criar Marca</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<tg:aviso/>
<form action="executa">
	<input type="hidden" name="operacao" value="GravaMarca"/>
	<div class="box">	
		<input type="hidden" name="id" value="${marca.id}"/>
		<p><tg:campoTexto label="Nome"  nameInput="nome" idInput="nome" value="${marca.nome}"></tg:campoTexto></p>
		<div class="box_botao">
			<input class="botao_cria" type="submit" value="Cria"/>
			<a class="link_pesquisa" href="pesquisa/marca_pg.jsp"/>Pesquisa</a>  
		</div>
	</div>
</form>
