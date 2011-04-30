package assistec.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import assistec.model.bean.Marca;

public class GenericHibernateDAO<T> implements DAO<T> {
	private Session session;
	
	
	public GenericHibernateDAO(Session session) {
		super();
		this.session = session;
	}

	@Override
	public Long insert(T t) {
		Long result = null;
		try {
			result = (Long) session.save(t);
			return result;
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(T t) {
		try {
			System.out.println( "Atualizando "  + t );
			session.update(t);
			System.out.println( "Atualizado "  + t );
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}
	
	
	@Override
	public void saveUpdate(T t) {
		try {
			session.saveOrUpdate(t);
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}

	@Override
	public void remove(Long id, Class classe) {
		try {
			T t = (T) session.get(classe, id);
			session.delete(t);
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}

	@Override
	public T search(Serializable id,Class classe ) {
		try {
			return (T)	session.get(classe, id);
		} catch (Exception e ) {
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Serializable value , String propertyName,Class classe) {
		try {
			Criteria criteria = session.createCriteria(classe);
			return criteria.list();
		} catch ( Exception e ) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<T> listLike(Serializable value, String propertyName,Class classe) {
		try {
			Criteria criteria = session.createCriteria(classe);
			return criteria.add(Restrictions.like(propertyName, value+"%")).list();
		} catch ( Exception e ) {
			throw new DAOException(e);
		} 
	}

	@Override
	public List<T> listAll(Class classe) {
		try {
			Criteria criteria = session.createCriteria(classe);
			return criteria.list();
		} catch ( Exception e ) {
			throw new DAOException(e);
		} 
	}

	@Override
	public List<T> list(String hql,String property, Object value) {
		try {
			Query query = (Query) session.createQuery(hql );
			query.setParameter(property, value);
			return query.list();
		} catch ( Exception e ) {
			throw new DAOException(e);
		} 
	}

	public static void main(String[] args) {
	}
}
