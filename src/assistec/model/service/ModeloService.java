package assistec.model.service;

import java.util.List;

import org.hibernate.Session;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;
import assistec.util.UtilAssistec;

public class ModeloService {
	
	public List<Modelo>pesquisaPorIdMarca(String strIdMarca) throws ServiceException {
		Session session = null;
		try {
			List<Modelo> lista = null;
			Long idMarca = Long.parseLong(strIdMarca);
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			lista = new GenericHibernateDAO<Modelo>(session).list(
					"from Modelo as modelo where marca.id=:id", "id",idMarca);
			session.getTransaction().commit();
			return lista;
		} catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	/** obtem Modelo por id */
	public Modelo seleciona(String paramId) {
		Session session = null;
		Modelo modelo = null;
		try{
			Long idModelo = Long.parseLong(paramId);
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			modelo = new GenericHibernateDAO<Modelo>(session).search(idModelo, 
					Modelo.class);
			session.getTransaction().commit();
			return modelo;
		} catch (Exception e ) {
			if (session!=null) {
				session.getTransaction().rollback();
			}
		}
		return modelo;
	}
	
	public Long grava (String strIdModelo , String descricao, String paramIdMarca) 
		throws ServiceException {
		Session session = null;
		try {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Long idMarca = Long.parseLong(paramIdMarca);
		Marca marca = new GenericHibernateDAO<Marca>(session).search(idMarca, Marca.class);
		GenericHibernateDAO<Modelo> modeloDAO = new GenericHibernateDAO<Modelo>(session);
		Modelo modelo=null;
		
		if (!UtilAssistec.isVazia(strIdModelo)) {
			modelo.setDescricao(descricao);
			modelo.setMarca(marca);
		} else {
			modelo = modeloDAO.search(Long.parseLong(strIdModelo), Modelo.class);
			modelo.setDescricao(descricao);
			modelo.setMarca(marca);
		}
		modeloDAO.saveUpdate(modelo);
		session.getTransaction().commit();
		return modelo.getId();
		} catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	public List<Modelo> pesquisaPorDescricao(String descricao) throws ServiceException{
		Session session = null;
		List<Modelo> lista = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			lista = new GenericHibernateDAO<Modelo>(session).listLike(descricao,"descricao",Modelo.class);
			session.getTransaction().commit();
			return lista;
		} catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}

}
