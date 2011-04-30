package assistec.controller.javascript;

import java.util.List;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.service.MarcaService;
import assistec.model.service.ModeloService;
import assistec.model.service.ServiceException;

public class MarcaFacadeAjax {
	
	/** lista todas as marcas*/
	public List<Marca> listMarca() {
//		System.out.println("Selecionando marcas");
		List<Marca> marcas = null;
		try {
			marcas = new MarcaService().listaTodas();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
//			new GenericHibernateDAO<Marca>(Marca.class).listAll();
//		System.out.println("total de marcas " + marcas.size());
		return marcas ;
	}
	
	/** lista marca por nome */
	public List<Marca> listMarca(String nome) {
		List<Marca>marcas = null;
		try {
			return new MarcaService().listaTodas();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return marcas;
	}
	
	/** lista modelos por id da marca */
	public List<Modelo> listModelo(String  idMarcaStr ) {
		List<Modelo>lista=null;
		try {
			lista = new ModeloService().pesquisaPorIdMarca(idMarcaStr);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lista;
	}
	

}
