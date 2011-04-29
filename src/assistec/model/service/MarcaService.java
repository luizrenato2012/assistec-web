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

			session.getTransaction().commit();
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

			session.getTransaction().commit();
			lista = new GenericHibernateDAO(session).listLike(nome, "nome", 
					Marca.class);
			session.getTransaction().commit();
		} catch(Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		return lista;
	}


}
