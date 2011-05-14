package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibePesquisaChamado implements ServiceITF{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getRequestDispatcher("pesquisa/chamado_pg.jsp")
			.forward(request, response);
	}

}
