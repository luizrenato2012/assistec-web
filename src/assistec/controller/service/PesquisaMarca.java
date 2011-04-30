package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.service.MarcaService;
import assistec.util.UtilAssistec;

public class PesquisaMarca implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String valor = request.getParameter("nome");
		if ( UtilAssistec.isVazia(valor)) {
			request.getRequestDispatcher( "/pesquisa/marca_pg.jsp").forward(request, response);
			return;
		}
		List<Marca> list = new MarcaService().listaNome(valor);
		if ( UtilAssistec.isVazia(list)) {
			request.setAttribute("msgAviso", "Marca não encontrada");
		} else {
			request.setAttribute("controlArg", valor);
			request.setAttribute("itens", list);
		}
		request.getRequestDispatcher( "/pesquisa/marca_pg.jsp").forward(request, response);
	}
	

}
