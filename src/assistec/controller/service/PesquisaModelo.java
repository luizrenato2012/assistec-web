package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class PesquisaModelo implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Modelo> dao = new GenericHibernateDAO<Modelo>(Modelo.class);
		//recebe descricao do modelo como parametro 
		String argDescricao = request.getParameter("descricao");
		if ( UtilAssistec.isVazia(argDescricao)) {
			request.getRequestDispatcher( "/pesquisa/modelo_pg.jsp").forward(request, response);
			return;
		}
		List<Modelo> list = dao.listLike(argDescricao, "descricao");
		if ( UtilAssistec.isVazia(list)) {
			request.setAttribute("msgAviso", "Modelo não encontrado");
		} else {
			request.setAttribute("controlArg", argDescricao);
			request.setAttribute("itens", list);
		}
		request.getRequestDispatcher( "/pesquisa/modelo_pg.jsp").forward(request, response);
	}
	

}
