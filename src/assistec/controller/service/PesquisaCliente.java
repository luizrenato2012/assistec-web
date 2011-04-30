package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.service.ClienteService;
import assistec.util.UtilAssistec;

public class PesquisaCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nome = request.getParameter("nome");
		if ( UtilAssistec.isVazia(nome)) {
			request.getRequestDispatcher( "/pesquisa/cliente_pg.jsp").forward(request, response);
			return;
		}
		List<Cliente> list = new ClienteService().pesquisaPorNome(nome);
		if ( UtilAssistec.isVazia(list)) {
			request.setAttribute("msgAviso", "Cliente não encontrado");
		} else {
			request.setAttribute("controlArg", nome);
			request.setAttribute("itens", list);
		}
		request.getRequestDispatcher( "/pesquisa/cliente_pg.jsp").forward(request, response);
	}
	

}
