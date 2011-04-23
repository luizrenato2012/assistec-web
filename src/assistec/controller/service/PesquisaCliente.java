package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class PesquisaCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Cliente> dao = new GenericHibernateDAO<Cliente>(Cliente.class);
		String valor = request.getParameter("nome");
		if ( UtilAssistec.isVazia(valor)) {
			request.getRequestDispatcher( "/pesquisa/cliente_pg.jsp").forward(request, response);
			return;
		}
		List<Cliente> list = dao.listLike(valor , "nome");
		if ( UtilAssistec.isVazia(list)) {
			request.setAttribute("msgAviso", "Cliente não encontrado");
		} else {
			request.setAttribute("controlArg", valor);
			request.setAttribute("itens", list);
		}
		request.getRequestDispatcher( "/pesquisa/cliente_pg.jsp").forward(request, response);
	}
	

}
