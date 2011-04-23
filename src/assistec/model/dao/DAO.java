package assistec.model.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO  <T> {
	
	public Serializable  insert (T t);
	public void update ( T t);
	public void remove ( Long id );
	public T search ( Serializable s );
	public List<T> listLike ( Serializable value , String name  );
	public List<T> list ( Serializable value , String name  );
	public List<T> listAll ( );
	public List<T> list (String hql , String property ,Object value );

}
