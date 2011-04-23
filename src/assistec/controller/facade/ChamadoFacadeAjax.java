package assistec.controller.facade;

import java.util.List;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.dao.GenericHibernateDAO;

public class ChamadoFacadeAjax {
	
	/** lista clientes por nome*/
	public List<Cliente> findCliente(String nome ) {
		return new GenericHibernateDAO<Cliente>(Cliente.class).listLike(nome,"nome");
	}
	
	/** lista clientes por nome*/
	public Cliente findClienteById(String paramId ) {
		Long id = Long.parseLong(paramId);
		System.out.println("findClienteById " + id);
		return new GenericHibernateDAO<Cliente>(Cliente.class).search(id);
	}
	
	/** lista equipamento por numero de serie */
	public List<Equipamento> findEquipamentoByNumSerie (String numeroSerie ) {
		return new GenericHibernateDAO(Equipamento.class).list(numeroSerie, "numeroSerie");		
	}
	
	/** lista equipamento por descricao do modelo */
	public List<Equipamento> findEquipamentoByModelo (String descricaoModelo ) {
		return new GenericHibernateDAO(Equipamento.class).list(" From Equipamento where modelo.descricao=:descricao",
				"descricao",descricaoModelo);		
	}
	
	public static void main(String[] args) {
//		List<Equipamento> lista = new ChamadoFacadeAjax().findEquipamentoByModelo("LS 1100");
//		if (lista!=null && lista.size()!= 0 ) {
//			for (Equipamento eq : lista) {
//				System.out.println( eq);
//			}
//		} else {
//			
//			System.out.println("Sem equipamentos");
//		}
		Cliente cliente = new GenericHibernateDAO<Cliente>(Cliente.class).search(
				Integer.parseInt("1"));
		System.out.println(cliente);
		
	}

}
