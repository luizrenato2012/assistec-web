package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class EditaMarca  implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Marca> dao = new GenericHibernateDAO<Marca>(Marca.class);
		if ( UtilAssistec.isVazia(request.getParameter("id"))) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/marca_pg.jsp").forward(request, response);
		} else {
			Long id = Long.parseLong( request.getParameter("id") );
			Marca marca = dao.search(id);
			if ( marca==null) {
				throw new RuntimeException("Marca com id " + id+ " não encontrado");
			}
			request.setAttribute("marca", marca);
			request.getRequestDispatcher( "marca_pg.jsp").forward(request, response);
		}
		
	}

}
