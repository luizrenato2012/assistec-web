package assistec.controller.javascript;

import java.util.ArrayList;
import java.util.List;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.service.ClienteService;
import assistec.model.service.EquipamentoService;
import assistec.model.service.ServiceException;
import assistec.util.UtilAssistec;

public class ChamadoFacadeAjax {
	
	/** lista clientes por nome*/
	public List<Cliente> findCliente(String nome ) {
//		return new GenericHibernateDAO<Cliente>(Cliente.class).listLike(nome,"nome");
		List<Cliente>lista=null;
		try {
			lista = new ClienteService().findbyNome(nome);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/** lista clientes por nome*/
	public Cliente findClienteById(String paramId ) {
//		Long id = Long.parseLong(paramId);
//		System.out.println("findClienteById " + id);
//		return new GenericHibernateDAO<Cliente>(Cliente.class).search(id);
		Cliente cliente = null;
		try {
			cliente = new ClienteService().findbyId(paramId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/** lista equipamento por numero de serie */
	public List<Equipamento> findEquipamentoByNumSerie (String numeroSerie ) {
		return this.findEquipamento("numeroSerie", numeroSerie);
	}
	
	/** lista equipamento por descricao do modelo */
	public List<Equipamento> findEquipamentoByModelo (String descricaoModelo ) {
//		return new GenericHibernateDAO(Equipamento.class).list(" From Equipamento where modelo.descricao=:descricao",
//				"descricao",descricaoModelo);		
		List<Equipamento>lista = this.findEquipamento("modelo", descricaoModelo);
		return  !UtilAssistec.isVazia(lista) ?lista : new ArrayList<Equipamento>();
	}
	
	/** pesquisa equipamento de acordo com argumento recebido */
	public List<Equipamento> findEquipamento (String tipoArgumento , String valor ) {
		List<Equipamento> lista = null;
		try {
			lista = new EquipamentoService().find(tipoArgumento, valor);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/** lista equipamento por numero de serie */
	public Equipamento findEquipamentoById(String strId) {
		Equipamento equipamento=null;
		try {
			System.out.println("findEquipamentoById");
			equipamento = new EquipamentoService().findById(strId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return equipamento;
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
//		Cliente cliente = new GenericHibernateDAO<Cliente>(Cliente.class).search(
//				Integer.parseInt("1"));
//		System.out.println(cliente);
		
	}

}
