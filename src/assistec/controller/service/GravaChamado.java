package assistec.controller.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.service.ChamadoService;
import assistec.model.service.ServiceException;

public class GravaChamado implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map parametros = request.getParameterMap();
		String dataHora = request.getParameter("dataHora");
		String solicitante = request.getParameter("solicitante");
		String defeito = request.getParameter("defeito");
		String observacao = request.getParameter("observacao");
		
		String idCliente = request.getParameter("idCliente");
		String idEquipamento = request.getParameter("id_equipamento");
		System.out.println("id_equipamento " + idEquipamento);
		try {
			Long idChamado = new ChamadoService().abreChamado(dataHora, 
					solicitante, defeito, observacao,idEquipamento, idCliente);
			request.setAttribute("msgAviso", "Chamado nº" + idChamado+ " aberto com sucesso");
			request.getRequestDispatcher("chamado_pg.jsp").forward(request, response);
		} catch (ServiceException e ) {
			e.printStackTrace();
			reenviaParametros(parametros, request);
			request.setAttribute("msgErro", e.getMessage());
			request.getRequestDispatcher("chamado_pg.jsp").forward(request, response);
		}

	}
	
	private void reenviaParametros (Map parametros , HttpServletRequest request){
		for(Object key : parametros.entrySet()) {
			request.setAttribute(key.toString() , parametros.get(key));
		}
	}

}
