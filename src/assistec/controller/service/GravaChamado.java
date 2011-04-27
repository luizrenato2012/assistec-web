package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Chamado;
import assistec.util.UtilAssistec;

public class GravaChamado implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String dataHora = request.getParameter("dataHora");
		String solictante = request.getParameter("solicitante");
		String defeito = request.getParameter("defeito");
		String observacao = request.getParameter("observacao");
		
		String idCliente = request.getParameter("idCliente");
		String idEquipamento = request.getParameter("id_equipamento");
		
		

	}

}
