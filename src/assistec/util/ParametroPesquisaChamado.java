package assistec.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que contem String c/ querys p/ pesquisa de chamados
 * @author renato
 *
 */
public class ParametroPesquisaChamado {
	
	private static Map<String,String> mapWhereQuery  = new HashMap<String,String>();
	private static String baseHql = "From Chamado as chamado join fetch chamado.cliente cliente " +
				" join fetch chamado.equipamento equipamento join fetch equipamento.marca marca" +
				" Join fetch equipamento.modelo modelo ";
	static {
		mapWhereQuery = new HashMap<String,String>();
		mapWhereQuery.put("id", 			  baseHql +" where chamado.id=:id");
		mapWhereQuery.put("dataHoraAbertura", baseHql +" where cast(chamado.dataHoraAbertura as date) = :dataHoraAbertura");
		mapWhereQuery.put("numeroSerie",      baseHql +" where equipamento.numeroSerie like :numeroSerie");
		mapWhereQuery.put("patrimonio",       baseHql +" where equipamento.patrimonio like :patrimonio");
		mapWhereQuery.put("cliente", 	      baseHql +" where cliente.nome like :cliente");
	}
	
	public static String getQuery(String tipo ) {
		if ( !mapWhereQuery.containsKey(tipo) ) {
			throw new RuntimeException("Tipo de parametro " + tipo + " invalido");
		}
		return mapWhereQuery.get(tipo);
	}

}
