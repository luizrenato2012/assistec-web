package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.service.ClienteService;

public class ExibeCliente implements ServiceITF {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paramId = request.getParameter("id");
		if (paramId!=null) {
			Cliente cliente = new ClienteService().selecionaPorId(paramId);
			if ( cliente==null) {
				throw new RuntimeException("Cliente com id " + paramId+ " não encontrado");
			}
			request.setAttribute("cliente", cliente);
		} 
		request.setAttribute("listUf", ListaUf.getLista());
		request.getRequestDispatcher( "cliente_pg.jsp").forward(request, response);
	}

}
