package assistec.model.service;

import java.util.List;

import org.hibernate.Session;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;

public class ClienteService {
	
	public List<Cliente> findbyNome(String nome) throws ServiceException {
		Session session = null;
		try {
			List<Cliente> lista = null;
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Cliente>clienteDAO = new GenericHibernateDAO<Cliente>(session);
			lista = clienteDAO.listLike(nome, "nome", Cliente.class);
			session.getTransaction().commit();
			return lista;
		}catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	public Cliente findbyId(String strId) throws ServiceException {
		Session session = null;
		Cliente cliente = null;
		try {
			Long id = Long.parseLong(strId);
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Cliente>clienteDAO = new GenericHibernateDAO<Cliente>(session);
			cliente = clienteDAO.search(id, Cliente.class);
			session.getTransaction().commit();
		}catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		return cliente;
	}
	
	

}
