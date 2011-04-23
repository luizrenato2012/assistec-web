package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;


public class GravaModelo implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if ( UtilAssistec.isVazia( request.getParameter("descricao") ) ){
			request.setAttribute("msgErro", "Descrição inválida");
			try {
				request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		
		String descricao = request.getParameter("descricao");
		String idMarca = request.getParameter("marca");
		Marca marca = null ; 
		GenericHibernateDAO<Marca> marcaDao =  new GenericHibernateDAO<Marca>(Marca.class);
		if ( !UtilAssistec.isVazia(idMarca)) {
			marca = marcaDao.search(Long.parseLong(idMarca));
		}
		GenericHibernateDAO<Modelo> dao = new GenericHibernateDAO<Modelo>(Modelo.class);
		
		Modelo modelo =null;
		Long id=null;
		String aviso = null;
		if ( request.getParameter("id")==null ||  request.getParameter("id").trim().equals("")) {
			modelo = new Modelo();
			modelo.setDescricao(descricao);
			modelo.setMarca(marca);
			id = dao.insert(modelo);
			aviso=id + " criado com sucesso";
		} else {
			id = Long.parseLong(request.getParameter("id"));
			modelo = dao.search(id);
			if ( modelo==null) {
				throw new RuntimeException("modelo inválido");
			}
			modelo.setDescricao(descricao);
			modelo.setMarca(marca);
			
			dao.update(modelo);
			aviso = id +" alterado com sucesso";
		}
		
		try {
			request.setAttribute("msgAviso", "Modelo " + aviso );
			request.setAttribute("marcas" , marcaDao.listAll());
			request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
