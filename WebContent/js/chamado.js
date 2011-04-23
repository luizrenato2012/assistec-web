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
	
}
/** preenche fields de equipamento */
function fillEquipamentoTable (equipamento) {
	
}