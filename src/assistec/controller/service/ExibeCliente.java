package assistec.controller.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;

public class ExibeCliente implements ServiceITF {
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Cliente> dao = new GenericHibernateDAO<Cliente>(Cliente.class);
		Long id = null;
		if (request.getParameter("id")!=null) {
			id = Long.parseLong( request.getParameter("id") );
			Cliente cliente = dao.search(id);
			if ( cliente==null) {
				throw new RuntimeException("Cliente com id " + id+ " não encontrado");
			}
			request.setAttribute("cliente", cliente);
		} 
		request.setAttribute("listUf", ListaUf.getLista());
		request.getRequestDispatcher( "cliente_pg.jsp").forward(request, response);
	}

}
