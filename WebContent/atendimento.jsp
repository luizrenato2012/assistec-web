
<div class="box_titulo">
<h3 class="titulo_rotulo">Registra Atendimento</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="assistec"%>
<tg:aviso/>
<form>
	<div class="box">	
	<p><assistec:campoTexto idInput="numChamado" label="Nº Chamado" nameInput="numChamado"/></p>
	<p><assistec:campoTexto idInput="cliente" label="Cliente" nameInput="dataHora"/></p>
	<p><assistec:campoTexto idInput="equipamento" label="Equipamento" nameInput="equipamento.descricao"/></p>
	<p><assistec:campoTexto idInput="marca" label="Marca" nameInput="equipamento.marca"/></p>
	<p><assistec:campoTexto idInput="modelo" label="Modelo" nameInput="equipamento.modelo"/></p>
	<p><assistec:campoTexto idInput="numSerie" label="Nº Serie" nameInput="equipamento.numeroSerie"/></p>
	<p><assistec:campoTexto idInput="defeito" label="Defeito" nameInput="chamado.defeito"/></p>
	<p><assistec:campoTexto idInput="data" label="Data" nameInput="data"/></p>
	<p><assistec:campoTexto idInput="dataHoraInicial" label="Hora Inicial" nameInput="horaInicial"/></p>
	<p><assistec:campoTexto idInput="dataHoraInicial" label="Hora Final" nameInput="horaFinal"/></p>
	<p><assistec:campoTexto idInput="defeito" label="Defeito" nameInput="defeito"/></p>
	<p><assistec:campoTexto idInput="descricao" label="Descricao" nameInput="descricao"/></p>
	<p><assistec:campoTexto idInput="observacao" label="Observacao" nameInput="observacao"/></p>
	<div class="box_botao">
	<input class="botao_cria" type="submit"  value="Registra"/>
	<a class="link_pesquisa" href="pesquisa.html"/>Pesquisa</a>
	</div>
</form>
