package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;


public class GravaMarca implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if ( UtilAssistec.isVazia( request.getParameter("nome") ) ){
			request.setAttribute("msgErro", "Nome inválido");
			try {
				request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		
		String nome = request.getParameter("nome");
		String idMarca = request.getParameter("marca");
		GenericHibernateDAO<Marca> dao = new GenericHibernateDAO<Marca>(Marca.class);
		
		Marca marca =null;
		Long id=null;
		String aviso = null;
		if ( request.getParameter("id")==null ||  request.getParameter("id").trim().equals("")) {
			marca = new Marca();
			marca.setNome(nome);
			id = dao.insert(marca);
			aviso=id + " criado com sucesso";
		} else {
			id = Long.parseLong(request.getParameter("id"));
			marca = dao.search(id);
			if ( marca==null) {
				throw new RuntimeException("marca inválida");
			}
			marca.setNome(nome);
			dao.update(marca);
			aviso = id +" alterado com sucesso";
		}
		
		try {
			request.setAttribute("msgAviso", "Marca " + aviso );
			request.getRequestDispatcher("marca_pg.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
