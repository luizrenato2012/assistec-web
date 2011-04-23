package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceITF {
	public void execute (HttpServletRequest request , HttpServletResponse response ) throws Exception ;
}
