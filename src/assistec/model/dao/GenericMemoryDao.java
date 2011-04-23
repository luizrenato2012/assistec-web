package assistec.model.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericMemoryDao<T>  implements DAO <T>{
	private List<T> list ; 
	
	
	
	public GenericMemoryDao() {
		list = new ArrayList<T>();
	}

	@Override
	public Serializable insert(T t) {
		list.add(t);
		return null;
	}

	@Override
	public void remove(Long id) {
	}

	@Override
	public T search(Serializable s) {
			return null;
	}

	@Override
	public void update(T t) {
		for ( T t2 : list) {
			if ( t2.equals(t)) {
				t2=t;;
			}
		}
	}

	@Override
	public List<T> list(Serializable value, String name) {
		for (T t : list) {
			Class classe = t.getClass();
			try {
				name = getNomeMetodo(name);
				Field campo = classe.getDeclaredField(name);
				Class classeCampo = campo.getType();
//				campo.getType()
				Method method = classe.getMethod(name, null);
				 Object res = method.invoke(t, null);
				Object obj = classe.newInstance();
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return this.list;
	}
	
	private static String getNomeMetodo( String campo ) {
		String upper = new String(campo.charAt(0)+"").toUpperCase() + campo.substring(1);
		return  "get" + upper;
	}


	public static void main(String[] args) {
		System.out.println(getNomeMetodo("nome"));
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listLike(Serializable value, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> list(String hql, String property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
