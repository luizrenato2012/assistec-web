package assistec.model.service;

import java.util.List;

import org.hibernate.Session;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;
import assistec.util.UtilAssistec;

public class ClienteService {
	
	public List<Cliente> pesquisaPorNome(String nome) throws ServiceException {
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
	
	public Cliente selecionaPorId(String strId) throws ServiceException {
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
	
	public List<Cliente> listaTodos() throws ServiceException {
		Session session = null;
		try {
			List<Cliente> lista = null;
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			lista = new GenericHibernateDAO<Cliente>(session).listAll(Cliente.class);
			session.getTransaction().commit();
			return lista;
		}catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	public void exclui(String paramId) throws ServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			new GenericHibernateDAO<Cliente>(session).remove(Long.parseLong(paramId), 
					Cliente.class);
			session.getTransaction().commit();
		}catch (Exception e ) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	public Long gravaCliente(Cliente cliente ) throws ServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Cliente> clienteDAO = new GenericHibernateDAO<Cliente>(session);
			clienteDAO.saveUpdate(cliente);
			session.getTransaction().commit();
			return cliente.getId();
		}catch (Exception e) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	public Long gravaCliente(String nome,String endereco,String cidade,String uf, 
			String telefone,String paramId) throws ServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Cliente> clienteDAO = new GenericHibernateDAO<Cliente>(session);
			Cliente cliente=null;
			
			if(UtilAssistec.isVazia(paramId)) {
				cliente = new Cliente();
			} else {
				cliente = clienteDAO.search(Long.parseLong(paramId), Cliente.class);
			}
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setCidade(cidade);
			cliente.setUf(uf);
			cliente.setTelefone(telefone);
			
			clienteDAO.saveUpdate(cliente);
			session.getTransaction().commit();
			return cliente.getId();
		}catch (Exception e) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
	}
	
	
	

}
