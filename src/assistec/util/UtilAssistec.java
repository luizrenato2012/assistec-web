package assistec.util;

import java.util.List;

/**
 * 
 * @author Luiz Renato
 *Data: 08/03/2011
 */
public class UtilAssistec {
	
	/** verifica se a String é nula/vazia */
	public static boolean isVazia (String str ) {
		return str==null || str.trim().equals("") || str.length()==0 ;
	}
	
	/** verifica se a lista é nula/vazia */
	public static <T>boolean isVazia( List<T>  list ) {
		return list==null || list.size()==0;
	}

}
