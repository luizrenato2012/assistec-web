package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.service.ChamadoService;
import assistec.model.service.ServiceException;

public class GravaChamado implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String dataHora = request.getParameter("dataHora");
		String solicitante = request.getParameter("solicitante");
		String defeito = request.getParameter("defeito");
		String observacao = request.getParameter("observacao");
		
		String idCliente = request.getParameter("idCliente");
		String idEquipamento = request.getParameter("id_equipamento");
		
		try {
		new ChamadoService().abreChamado(dataHora, solicitante, defeito, observacao, 
				idEquipamento, idCliente);
		} catch (ServiceException e ) {
			request.setAttribute("msgErro", e.getMessage());
			request.getRequestDispatcher("chamado_pg.jsp").forward(request, response);
		}

	}

}
