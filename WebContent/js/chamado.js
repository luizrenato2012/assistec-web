/** pesquisa cliente p/ preencher tabela */
function findCliente() {
	var nome = dwr.util.getValue('argNome');
	ChamadoFacadeAjax.findCliente(nome,fillClienteTable);
}
/** preenche  campos da tabela */
function fillClienteTable(list) {
	cellFuncs = [
	            function(data) { return "<input type=\'radio\' name=\'radio\' onclick=\'selectCliente("+ data.id + ")\'/>"+data.id ;} , 
	            function(data) { return data.nome ;} ,
	            function(data) { return data.cidade   ;} , 
	            function(data) { return data.uf ;} 
	            ];	
	dwr.util.removeAllRows("tbodyCliente");
	dwr.util.addRows("tbodyCliente" , list, cellFuncs , {escapeHtml:false});
}

function resetTable(table) {
	dwr.util.removeAllRows(table);
}

function findClienteId(id) {
	ChamadoFacadeAjax.findClienteById(id, fillCliente);
}

function fillCliente(cliente) {
	dwr.util.setValue("nome",cliente.nome);
	dwr.util.setValue("cidade",cliente.cidade);
	dwr.util.setValue("endereco",cliente.endereco);
	dwr.util.setValue("telefone",cliente.telefone);
}


/** pesquisa equipamento por numero de serie*/
function findEquipamento() {
	var tipo = dwr.util.getValue('cbx_equipamento');
	var valor = dwr.util.getValue('argPesquisaEquipamento');
	ChamadoFacadeAjax.findEquipamento(tipo,valor,fillTblEquipamento);
	
}
/** preenche fields de equipamento */
function fillTblEquipamento (list) {
	cellFuncs = [
		            function(data) { return "<input type=\'radio\' name=\'radio\' onclick=\'selectEquipamento("+ data.id + ")\'/>"+data.id ;} , 
		            function(data) { return data.descricao ;} ,
		            function(data) { return data.marca.nome   ;} , 
		            function(data) { return data.modelo.descricao ;},
		            function(data) { return data.numeroSerie ;},
		            function(data) { return data.patrimonio;},
		            function(data) { return data.cliente.nome;},
		            ];	
		dwr.util.removeAllRows("tbodyEquipamento");
		dwr.util.addRows("tbl_equipamento" , list, cellFuncs , {escapeHtml:false});
}
function findEquipamentoId(id) {
	ChamadoFacadeAjax.findEquipamentoById(id, fillEquipamento);
}

function fillEquipamento(equipamento) {
	dwr.util.setValue("descricao",equipamento.descricao);
	dwr.util.setValue("marca",equipamento.marca.nome);
	dwr.util.setValue("modelo",equipamento.modelo.descricao);
	dwr.util.setValue("numeroSerie",equipamento.numeroSerie);
	dwr.util.setValue("patrimonio",equipamento.patrimonio);
}