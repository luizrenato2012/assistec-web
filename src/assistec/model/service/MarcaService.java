package assistec.model.service;

import java.util.List;

import org.hibernate.Session;

import assistec.model.bean.Marca;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;

public class MarcaService {
	
	public List<Marca> listaTodas() throws ServiceException {
		Session session=null;
		List<Marca>lista=null;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			lista = new GenericHibernateDAO(session).listAll(Marca.class);
			session.getTransaction().commit();
		} catch(Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		return lista;
	}
	
	public List<Marca> listaNome(String nome) throws ServiceException {
		Session session=null;
		List<Marca>lista=null;
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			lista = new GenericHibernateDAO<Marca>(session).listLike(nome, "nome", Marca.class);
			session.getTransaction().commit();
		} catch(Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		return lista;
	}
	
	/** 
	 * seleciona uma Marca pelo id 
	 */
	public Marca seleciona(String paramId) throws ServiceException {
		Session session=null;
		try{
			Marca marca = null;
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			marca=  new GenericHibernateDAO<Marca>(session).search(Long.parseLong(paramId), 
					Marca.class);
			session.getTransaction().commit();
			return marca;
		} catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		
	}


}
