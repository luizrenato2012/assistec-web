package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;


public class EditaEquipamento implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GenericHibernateDAO<Equipamento> dao = new GenericHibernateDAO<Equipamento>();
		if ( UtilAssistec.isVazia(request.getParameter("id"))) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/equipamento_pg.jsp").forward(request, response);
		} else {
			Long id = Long.parseLong( request.getParameter("id") );
			Equipamento equipamento = dao.search(id);
			if ( equipamento==null) {
				throw new RuntimeException("Equipamento com id " + id+ " não encontrado");
			}
			request.setAttribute("equipamento", equipamento);
//			request.setAttribute("listUf", ListaUf.getLista());
			//ao editar equipamento é necessario envia listas de marca,modelo e cliente
			//no form deve-se implementar logica de selecao de cada um de acordo com os atributos do arquipamento
			//via javascript/DWR
			List<Marca> listaMarca = new GenericHibernateDAO(Marca.class).listAll();
			request.setAttribute("listaMarca", listaMarca);
			List<Cliente>listaCliente = new GenericHibernateDAO(Cliente.class).listAll();
			request.setAttribute("listaCliente", listaCliente);
			request.getRequestDispatcher( "equipamento_pg.jsp").forward(request, response);
		}
	}

}
