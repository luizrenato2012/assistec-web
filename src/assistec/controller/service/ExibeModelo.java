package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class ExibeModelo implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Marca> dao = new GenericHibernateDAO<Marca>(Marca.class);
		//lista com todas as marcas p/ escolha no cadastro de modelo
		List<Marca> marcas = dao.listAll();
		Modelo modelo=null;
		if ( UtilAssistec.isVazia( marcas))  {
			request.setAttribute("msgErro","Erro ao carregar lista de marcas");
		} else {
			request.setAttribute("marcas",marcas);
		}
		if (!UtilAssistec.isVazia(request.getParameter("id") )) {
			modelo = new GenericHibernateDAO<Modelo>(Modelo.class).search(
					Long.parseLong(request.getParameter("id")));
			request.setAttribute("modelo",modelo);
		}
		request.getRequestDispatcher("/modelo_pg.jsp").forward(request, response);
	}

}
