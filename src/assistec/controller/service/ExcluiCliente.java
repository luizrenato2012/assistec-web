package assistec.controller.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class ExcluiCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id") ;
		if ( UtilAssistec.isVazia( idStr) ){
			request.setAttribute("msgErro", "Id inválido");
			try {
				request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		GenericHibernateDAO<Cliente> dao = new GenericHibernateDAO<Cliente>(Cliente.class);
		Long id = Long.parseLong( idStr );
		dao.remove(id);
		request.setAttribute("msgAviso", "Cliente excluído com sucesso!");
		
		String argumento = request.getParameter("viewArg");
		System.out.println("viewArg " + argumento);
		List<Cliente> list = dao.list("%"+argumento+"%", "nome");
		if (list==null ) {
			System.out.println("Sem clientes ");
		} else {
			System.out.println("Quantidade de clientes " + list.size());
		}
		request.setAttribute("itens", list);
		request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
	}

}
