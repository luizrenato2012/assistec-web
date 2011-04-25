
<div class="box_titulo_2">
	<h3 class="titulo_rotulo">Abre Chamado</h3>
</div>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="assistec"%>
<tg:aviso/>
<form id="frmstylizer" action="#" method="post">
	<!-- <label class="label_secao">Chamado</label>   -->
  	<fieldset>
   		<label class="small">Data/Hora &#42; <input type="text" id="dataHora" class="text" /></label>
   		<label class="small">Solicitante &#42; <input type="text" class="text" /></label>
   		<label class="large">Defeito Reclamado &#42; <input type="text" class="text" /></label>
 	</fieldset>
   <label class="label_secao">Cliente</label> 
		<fieldset>
   	<!-- <label class="large">Nome &#42; <input type="text" class="textfield" id="nome"/></label> 
   		<label class="small">Telefone &#42; <input type="text" class="textfield" id="telefone"/></label>
   		<label class="small">Pesquisar <input type="button" class="textfield" id="btnPesquisaCliente" value="..."/></label><br/>
		<label class="large">Endereço &#42; <input type="text" class="textfield" id="endereco"/></label>
   		<label class="small">Cidade &#42; <input type="text" class="textfield" id="cidade"/></label> -->
   		 <label class="large">Nome &#42; <label class="textfield" id="nome"></label></label> 
   		<label class="small">Telefone <label  class="textfield" id="telefone"/></label></label>
   		<label class="small">Pesquisar <input type="button" class="button" id="btnPesquisaCliente" value="..."/></label><br/>
		<label class="large">Endereço  <label class="textfield" id="endereco"/></label></label>
   		<label class="small">Cidade  <label class="textfield" id="cidade"/></label></label> 
   		<label class="small">UF   
		<select class="select">
	  		<option value="RJ">RJ</option>
	  		<option value="SP">SP</option>
	  		<option value="MG">MG</option>
	  		<option value="ES">ES</option>	  
	 	</select></label> <br/>
	</fieldset>
  <label class="label_secao">Equipamento</label> 
	<fieldset>
   		<label class="large">Decricao &#42; <input type="text" class="textfield" /></label>
   		<label class="small">Marca <input type="text" class="textfield" /></label>
   		<label class="small">Modelo <input type="text" class="textfield" /></label> <br/>

   		<label class="large">Núm. Série <input type="text" class="textfield" /></label>
   		<label class="large">Patrimonio <input type="text" class="textfield" /></label><br/>
    
   		<label class="full">Observação <input type="text" class="textfield" /></label>
   		</fieldset>
  		<div class="box_botao_2">
			<input class="botao_cria" type="submit"  value="Cria"/>
			<a class="link_pesquisa" href="pesquisa.html"/>Pesquisa</a>
		</div>
 </form>
 <!--  -------------Pesquisa de cliente      -->
 <script>
 	function selectCliente(id) {
 	 	 $("#idCliente").val(id);
 	}
 </script>
 
    <input type="hidden" id="idCliente"/>
    <div id="dialog" title="Pesquisa de Clientes" >
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
 <!--  -------------Pesquisa de cliente      -->
