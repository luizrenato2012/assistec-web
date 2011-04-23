package assistec.util;

import java.util.List;

/**
 * 
 * @author Luiz Renato
 *Data: 08/03/2011
 */
public class UtilAssistec {
	
	public static boolean isVazia (String str ) {
		return str==null || str.trim().equals("") || str.length()==0 ;
	}
	
	public static boolean isVazia( List  list ) {
		return list==null || list.size()==0;
	}

}
