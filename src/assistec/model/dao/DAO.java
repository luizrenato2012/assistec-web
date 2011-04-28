package assistec.model.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO  <T> {
	
	public Serializable  insert (T t);
	public void update ( T t);
	public void remove ( Long id ,Class classe);
	public T search ( Serializable s,Class classe );
	public List<T> listLike ( Serializable value , String name,Class classe  );
	public List<T> list ( Serializable value , String name,Class classe  );
	public List<T> listAll ( Class classe);
	public List<T> list (String hql , String property ,Object value );

}
