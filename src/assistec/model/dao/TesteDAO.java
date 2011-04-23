package assistec.model.dao;

import assistec.model.bean.Cliente;

public class TesteDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericHibernateDAO<Cliente> clienteDAO = new GenericHibernateDAO<Cliente>(Cliente.class);
		Cliente cl = clienteDAO.search(new Long(2));
		if (cl != null ) {
			System.out.println( cl );
		} else {
			System.out.println("Não foi encontrado cliente ");
		}
		
 	}

}
