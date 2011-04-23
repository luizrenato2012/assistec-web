package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;

public class ExibeEquipamento implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericHibernateDAO<Equipamento> dao = new GenericHibernateDAO<Equipamento>(Equipamento.class);
		Long id = null;
		if (request.getParameter("id")!=null) {
			id = Long.parseLong( request.getParameter("id") );
			Equipamento equipamento = dao.search(id);
			if ( equipamento==null) {
				throw new RuntimeException("Cliente com id " + id+ " não encontrado");
			}
			request.setAttribute("equipamento", equipamento);
		} 
		
		GenericHibernateDAO<Marca> daoMarca = new GenericHibernateDAO<Marca>(Marca.class);
		List<Marca> listaMarca = daoMarca.listAll();
		request.setAttribute("listaMarca", listaMarca);
		GenericHibernateDAO<Cliente> clienteDao =  new GenericHibernateDAO<Cliente>(Cliente.class);
		List<Cliente>listaCliente = clienteDao.listAll();
		request.setAttribute("listaCliente", listaCliente);
		request.getRequestDispatcher( "equipamento_pg.jsp").forward(request, response);
	}

}
