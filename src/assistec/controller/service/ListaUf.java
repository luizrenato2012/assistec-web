package assistec.controller.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaUf {
	private static List<String>listUf = null;
	
	static {
		listUf = Arrays.asList("AC","AM","BA","CE","DF","GO","MA","PA","PB","PR",
				"RS","RN","TO","SP","SE","SC","ES","MG","MS","MT","RO","RR","SC","PE");
		Collections.sort(listUf);
	}
	
	public static  List<String> getLista() {
		return listUf;
	}
	
}
