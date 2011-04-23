package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class ExcluiMarca implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id") ;
		if ( UtilAssistec.isVazia( idStr) ){
			request.setAttribute("msgErro", "Id inválido");
				request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
				return;
		} 
		GenericHibernateDAO<Marca> dao = new GenericHibernateDAO<Marca>(Marca.class);
		Long id = Long.parseLong( idStr );
		dao.remove(id);
		request.setAttribute("msgAviso", "Marca excluída com sucesso!");
		
		String argumento = request.getParameter("viewArg");
		System.out.println("viewArg " + argumento);
		List<Marca> list = dao.list("%"+argumento+"%", "nome");
//		if (list==null ) {
//			System.out.println("Sem clientes ");
//		} else {
//			System.out.println("Quantidade de clientes " + list.size());
//		}
		request.setAttribute("itens", list);
		request.getRequestDispatcher("pesquisa/marca_pg.jsp").forward(request, response);
	}

}
