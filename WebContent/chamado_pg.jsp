<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Abertura de Chamado</title>
	<link rel="stylesheet" type="text/css" href="css/form.css" />
	<link rel="stylesheet" type="text/css" href="css/menu.css" />
 	<link rel="stylesheet" type="text/css" href="css/dialog.css" />  
	<link rel="stylesheet" type="text/css" href="css/frmstyle.css" />   
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type='text/javascript' src='dwr/interface/ChamadoFacadeAjax.js'></script>
 	<script type='text/javascript' src='dwr/engine.js'></script>
	<script type='text/javascript' src='dwr/util.js'></script>
	 <script type='text/javascript' src='js/chamado.js'></script>
	 <script src="js/form.js"></script>  
	  
	<link href="js/jquery/development-bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>
  	<script src="js/jquery/js/jquery-1.4.4.min.js"></script>
  	<script src="js/jquery/development-bundle/ui/jquery-ui-1.8.10.custom.js"></script>
	
	 <!--  tratamento de eventos pesquisa cliente e equipamentos -->
	 <script type="text/javascript">

        $('document').ready(function () { 
        	$("#btnPesquisaCliente").click(function (e)  {
                $("#dialog_cliente").dialog({modal:true,width:530});
                e.preventDefault(); 
            });

            $('#btnProcuraCliente').click(function(e){
               findCliente();
            });
            
            $('#btnSelecionaCliente').click(function(e){
                var id = dwr.util.getValue('idCliente');
                if (id!= null && id!='') {
                	findClienteId($('#idCliente').val() ); 	
         	 		$('#dialog_cliente').dialog('close');
                } else {
                	$('#msg_cliente').dialog();
                }
            });

            $('#btnPesquisaEquipamento').click(function(e) {
            	$("#dialog_equipamento").dialog({modal:true,width:590});
                e.preventDefault(); 
             });

            $('#btnProcuraEquipamento').click(function(e){
                findEquipamento();
             });

            $('#btnSelecionaEquipamento').click(function(e){
                var id = dwr.util.getValue('id_equipamento');
                if( id!=null&&  id!='' ) {
                    findEquipamentoId(id );
                  /*  dwr.util.setValue('id_equipamento',''); */
                    $('#dialog_equipamento').dialog('close');
                } else {
                   /* alert('Pesquisa de equipamento','Selecione um equipamento!'); */
                	$('#msg_Equipamento').dialog();
                }
            });
            function exibeErro(dialogErro) {
     	 		alert('Erro');
     	 /*		$(dialogErro).dialog(); */
     		}
        });
       
    </script>
    
    <!-- formatacao ao digitar dd/MM/aaaa HH:mm -->
	<script>
		function formataDataHora(evento, objeto){
			var keypress=(window.event)?event.keyCode:evento.which;
			campo = eval (objeto);
			if (campo.value == '00/00/0000 00:00:00') 		{
				campo.value=""
			}

			caracteres = '0123456789';
			separacao1 = '/';
			separacao2 = ' ';
			separacao3 = ':';
			conjunto1 = 2;
			conjunto2 = 5;
			conjunto3 = 10;
			conjunto4 = 13;
			conjunto5 = 16;
			/** 11/11/1111 11:11 */
			if ((caracteres.search(String.fromCharCode (keypress))!=-1) && campo.value.length < (17)) 	{
			if (campo.value.length == conjunto1 )
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto2)
			campo.value = campo.value + separacao1;
			else if (campo.value.length == conjunto3)
			campo.value = campo.value + separacao2;
			else if (campo.value.length == conjunto4)
			campo.value = campo.value + separacao3;
			else if (campo.value.length == conjunto5)
			campo.value = campo.value;
			}
			else
				event.returnValue = false;
			}
		</script>
	

</head>
<body>

	<div class="logo"></div>

	<div class="coluna_menu">
		<jsp:include page="menu.jsp"/>
	</div> 
	<div class="coluna_body_2">
		<jsp:include page="chamado.jsp"/>
	</div>
</body>
</html>
