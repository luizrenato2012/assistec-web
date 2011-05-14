<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="assistec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box_titulo_2">
<!-- <h3 class="small">Abre Chamado</h3>  -->
	<label id="label_secao_chamado">Abre Chamado</label><br>
 <tg:aviso_chamado/>  
</div>
<form id="frmstylizer" action="executa" method="get">
	<input type="hidden" name="operacao" value="GravaChamado"/>
  	<fieldset>
   		<label class="small">Data/Hora &#42; <input type="text" id="dataHora" name="dataHora" 
   			class="text" value="${param.dataHora}" onkeypress="formataDataHora(event,this)" maxlength="16"/></label>
   		<label class="small">Solicitante &#42; <input type="text" name="solicitante" class="text" value="${param.solicitante}"/></label>
   		<label class="large">Defeito Reclamado &#42; <input type="text" name="defeito" class="text" value="${param.defeito}"/></label>
   		<label class="full">Observacao <input type="text" name="observacao" class="text" value="${param.defeito}"/></label>
 	</fieldset>
   <label class="label_secao">Cliente</label> 
		<fieldset>
  		 <label class="large">Nome &#42; <label class="textfield" id="nome"></label></label> 
   		<label class="small">Telefone <label  class="textfield" id="telefone"/></label></label>
   		<label class="small">Pesquisar <input type="button" class="button" id="btnPesquisaCliente" value="..."/></label><br/>
		<label class="large">Endereço  <label class="textfield" id="endereco"/></label></label>
   		<label class="small">Cidade  <label class="textfield" id="cidade"/></label></label> 
   		<label class="small">UF   
		<select class="select">
	  		<option value="RJ">AC</option>
	  		<option value="SP">AM</option>
	  		<option value="MG">BA</option>
	  		<option value="ES">CE</option>	  
	  		<option value="ES">DF</option>
	  		<option value="ES">MG</option>
	  		<option value="ES">PA</option>
	  		<option value="ES">SP</option>
	  		<option value="ES">RJ</option>
	  		<option value="ES">TO</option>
	 	</select></label> <br/>
	</fieldset>
  <label class="label_secao">Equipamento</label> 
	<fieldset>
   		<label class="x-large">Decricao &#42; <label id="descricao" class="textfield" /></label></label> 
   		<label class="small">Pesquisar <input type="button" class="button" id="btnPesquisaEquipamento" value="..."/> </label><br/>
   		
   		<label class="large">Marca <label id="marca" class="textfield" /></label></label>
   		<label class="large">Modelo <label id="modelo"  class="textfield" /></label></label> <br/>

   		<label class="large">Núm. Série <label id="numeroSerie" class="textfield" /></label></label>
   		<label class="large">Patrimonio <label id="patrimonio" class="textfield" /></label></label><br/>
    
   		</fieldset>
  		<div class="box_botao_2">
			<input class="botao_cria" type="submit"  value="Cria"/>
			<c:url value="${applicationContext}/" var="applicationPath"/>
			<a class="link_pesquisa" href="${applicationPath}executa?operacao=ExibePesquisaChamado"/>Pesquisa</a>
		</div>
    <input type="hidden" id="idCliente" name="idCliente" value="${param.idCliente}"/>
    <input type="hidden" id="id_equipamento" name="id_equipamento" value="${param.id_equipamento}"/>
 </form>
 <!--  -------------Pesquisa de cliente      -->
 <script>
 	function selectCliente(id) {
 	 	 $("#idCliente").val(id);
 	}
 	function selectEquipamento(id) {
 	 	$('#id_equipamento').val(id);
 	}
 </script>
 
    <div id="dialog_cliente" class="dialog" title="Pesquisa de Clientes" >
      	<br>
     	<label for="nome">Digite um nome</label><input type="text" id="argNome"/> 
     	<input type="button" id="btnProcuraCliente" value="Procura"/> <br><br>
     	<table id="tblCliente">
     		<tr>
     		<th> </th><th> Nome </th>  <th> Cidade</th> <th> UF</th>
     		</tr>
     		<tr>
     			<tbody id="tbodyCliente"/>
     		</tr>
     	</table><br><br>
     	<!-- evento definido em chamado_pg.jsp -->
     	<input type="button" value="Seleciona" id="btnSelecionaCliente"/>
     </div>

<!-- Pesquisa de Equipamento -->
    <div id="dialog_equipamento" class="dialog" title="Pesquisa de Equipamentos por" >
      	<br>
     	<select class="label" id="cbx_equipamento">
     		<option value="descricao">Descrição</option>
     		<option value="marca">Marca</option>
     		<option value="modelo">Modelo</option>
     		<option value="numeroSerie">N. Série</option>
     		<option value="patrimonio">Patrimônio</option>
     		<option value="cliente">Cliente</option>
     	</select>
     	
     	<input type="text" id="argPesquisaEquipamento"/>
     	
     	<input type="button" id="btnProcuraEquipamento" value="Procura"/> <br><br>
     	<table id="tbl_equipamento">
     		<tr>
     		<th>ID</th> <th> Descrição </th>  <th> Marca</th> <th> Modelo</th> <th>N. Série</th> <th>Patrimonio</th> <th>Cliente</th>
     		</tr>
     		<tr>
     			<tbody id="tbodyEquipamento"/>
     		</tr>
     	</table><br><br>
     	
     	<input type="button" value="Seleciona" id="btnSelecionaEquipamento"/>
     </div>
     <assistec:mensagemTag id="msg_Equipamento" titulo="Erro" mensagem="Selecione um equipamento"/>
     <assistec:mensagemTag id="msg_Cliente" titulo="Erro" mensagem="Selecione um cliente"/>