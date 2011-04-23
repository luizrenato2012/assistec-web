package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.GenericMemoryDao;
import assistec.util.UtilAssistec;


public class EditaCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GenericHibernateDAO<Cliente> dao = new GenericHibernateDAO<Cliente>(Cliente.class);
		if ( UtilAssistec.isVazia(request.getParameter("id"))) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
		} else {
			Long id = Long.parseLong( request.getParameter("id") );
			Cliente cliente = dao.search(id);
			if ( cliente==null) {
				throw new RuntimeException("Cliente com id " + id+ " não encontrado");
			}
			request.setAttribute("cliente", cliente);
			request.setAttribute("listUf", ListaUf.getLista());
			request.getRequestDispatcher( "cliente_pg.jsp").forward(request, response);
		}
	}

}
