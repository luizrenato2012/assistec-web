package assistec.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que contem String c/ querys p/ pesquisa de equipamentos
 * @author renato
 *
 */
public class ParametroPesquisaEquipamento {
	
	private static Map<String,String> mapParamQuery  = new HashMap<String,String>();
	
	static {
		mapParamQuery = new HashMap<String,String>();
		mapParamQuery.put("id", "From Equipamento as equipamento join fetch equipamento.cliente cliente where equipamento.id=:id");
		mapParamQuery.put("descricao", "From Equipamento as equipamento join fetch equipamento.cliente cliente where equipamento.descricao like :descricao");
		mapParamQuery.put("marca","From Equipamento as equipamento join fetch equipamento.cliente cliente where equipamento.marca.nome like :marca");
		mapParamQuery.put("modelo", "From Equipamento as equipamento join fetch equipamento.cliente cliente where equipamento.modelo.descricao like :modelo");
		mapParamQuery.put("numeroSerie", "From Equipamento equipamento join fetch equipamento.cliente cliente where numeroSerie like :numeroSerie");
		mapParamQuery.put("patrimonio", "From Equipamento equipamento join fetch equipamento.cliente cliente where equipamento.patrimonio like :patrimonio");
		
	}
	
	public static String getQuery(String tipo ) {
		if ( !mapParamQuery.containsKey(tipo) ) {
			throw new RuntimeException("Tipo de parametro " + tipo + " invalido");
		}
		return mapParamQuery.get(tipo);
	}

}
