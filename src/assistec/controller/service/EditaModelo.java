package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class EditaModelo  implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Modelo> dao = new GenericHibernateDAO<Modelo>(Modelo.class);
		if ( UtilAssistec.isVazia(request.getParameter("id"))) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/modelo_pg.jsp").forward(request, response);
		} else {
			Long id = Long.parseLong( request.getParameter("id") );
			Modelo modelo = dao.search(id);
			if ( modelo==null) {
				throw new RuntimeException("Modelo com id " + id+ " não encontrado");
			}
			GenericHibernateDAO<Marca> marcaDao = new GenericHibernateDAO<Marca>(Marca.class);
			List<Marca> marcas = marcaDao.listAll();
			request.setAttribute("modelo", modelo);
			request.setAttribute("marcas", marcas);
			request.getRequestDispatcher( "modelo_pg.jsp").forward(request, response);
		}
		
	}

}
