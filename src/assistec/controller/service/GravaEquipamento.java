package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.service.EquipamentoService;
import assistec.util.UtilAssistec;


public class GravaEquipamento implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		if ( UtilAssistec.isVazia( request.getParameter("descricao") ) ){
			request.setAttribute("msgErro", "Descriçao inválida");
			request.getRequestDispatcher("equipamento_pg.jsp").forward(request, response);
			return;
		} 

		String descricao = request.getParameter("descricao");
		String paramMarca = request.getParameter("marca");
		String paramModelo = request.getParameter("modelo");
		String paramCliente= request.getParameter("cliente");
		String numeroSerie = request.getParameter("numeroSerie");
		String patrimonio = request.getParameter("patrimonio");
		String observacao = request.getParameter("observacao");
		String paramId = request.getParameter("id");
		String aviso=null;


		Long id = new EquipamentoService().grava(paramId,descricao,paramMarca,paramModelo,
				paramCliente,observacao,patrimonio,numeroSerie);
		aviso= (paramId==null ||  paramId.trim().equals("")) ?
				id + " criado com sucesso":
					id + " alterado com sucesso";	
		request.setAttribute("msgAviso", "Equipamento " + aviso );
		request.getRequestDispatcher("executa?operacao=ExibeEquipamento").forward(request, response);

	}

}
