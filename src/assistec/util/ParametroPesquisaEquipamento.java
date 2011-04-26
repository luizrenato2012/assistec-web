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
		mapParamQuery.put("descricao", "From Equipamento where descricao like :descricao ");
		mapParamQuery.put("marca","From Equipamento where marca.nome like :marca");
		mapParamQuery.put("modelo", "From Equipamento where modelo.descricao like :modelo");
		mapParamQuery.put("numeroSerie", "From Equipamento where numeroSerie like :numeroSerie");
		mapParamQuery.put("patrimonio", "From Equipamento where patrimonio like :patrimonio");
	}
	
	public static String getQuery(String tipo ) {
		if ( !mapParamQuery.containsKey(tipo) ) {
			throw new RuntimeException("Tipo de parametro " + tipo + " invalido");
		}
		return mapParamQuery.get(tipo);
	}

}
