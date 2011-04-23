package assistec.controller.facade;

import java.util.List;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;

public class MarcaFacadeAjax {
	
	public List<Marca> listMarca() {
		System.out.println("Selecionando marcas");
		List<Marca> marcas = new GenericHibernateDAO<Marca>(Marca.class).listAll();
		System.out.println("total de marcas " + marcas.size());
		return marcas ;
	}
	
	public List<Marca> listMarca(String nome) {
		return new GenericHibernateDAO<Marca>(Marca.class).listLike(nome,"nome");
	}
	
	public List<Modelo> listModelo(String  idMarcaStr ) {
		Long idMarca = Long.parseLong(idMarcaStr);
		return new GenericHibernateDAO<Modelo>(Modelo.class).list("from Modelo as modelo where marca.id=:id", 
				"id", new Long(idMarca));
	}
	

}
