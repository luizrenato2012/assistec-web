package assistec.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import assistec.model.bean.Marca;

public class GenericHibernateDAO<T> implements DAO<T> {
	private Class classe ; 
	
	public GenericHibernateDAO(Class classe) {
		super();
		this.classe = classe;
	}

	@Override
	public Long insert(T t) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Long result = null;
		try {
		result = (Long) session.save(t);
		session.getTransaction().commit();
		return result;
		} catch (Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		}
	}

	@Override
	public void update(T t) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			System.out.println( "Atualizando "  + t );
			session.update(t);
			session.getTransaction().commit();
			System.out.println( "Atualizado "  + t );
		} catch (Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		}
	}

	@Override
	public void remove(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			T t = (T) session.get(classe, id);
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		}
	}

	@Override
	public T search(Serializable s ) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			return (T)	session.get(classe, s);
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Serializable value , String propertyName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(classe);
//			criteria.add(Restrictions.)
			return criteria.list();
		} catch ( Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		}
	}

	@Override
	public List<T> listLike(Serializable value, String propertyName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(classe);
			return criteria.add(Restrictions.like(propertyName, value+"%")).list();
		} catch ( Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		} 
	}

	@Override
	public List<T> listAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(classe);
			return criteria.list();
		} catch ( Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		} 
	}

	@Override
	public List<T> list(String hql,String property, Object value) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = (Query) session.createQuery(hql );
			query.setParameter(property, value);
			return query.list();
		} catch ( Exception e ) {
			session.getTransaction().rollback();
			throw new DAOException(e);
		} 
	}

	public static void main(String[] args) {
		List  list = new GenericHibernateDAO<Marca>(Marca.class).listLike("M", "nome");
		if ( list==null) {
			System.out.println("Sem marcas");
		} else {
			for ( Object obj :list) {
				System.out.println(  obj  );
			}
		}
	}
}
