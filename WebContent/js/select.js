function selecionaModelos() {
//	alert("seleciona modelos");
	var marca = dwr.util.getValue("divMarca");
	MarcaFacadeAjax.listModelo(marca,preencheComboModelo);
}

function preencheComboModelo( data ) {
	dwr.util.removeAllOptions("divModelo");
	dwr.util.addOptions("divModelo" , data , "id" , "descricao");
}

function listaMarcas() {
//	alert("lista marcas");
	MarcaFacadeAjax.listMarca(preencheComboMarca);
}

function preencheComboMarca(data) {
//	alert("preenche combo marca");
	dwr.util.addOptions("divMarca" , data , "id" , "nome");
}

function pesquisaMarca() {
	var nome = dwr.util.getValue("marca_arg",preencheTableMarca);
}
