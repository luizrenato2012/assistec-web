package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.service.MarcaService;
import assistec.model.service.ModeloService;
import assistec.model.service.ServiceException;
import assistec.util.UtilAssistec;


public class GravaModelo implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if ( UtilAssistec.isVazia( request.getParameter("descricao") ) ){
			request.setAttribute("msgErro", "Descrição inválida");
			try {
				request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		
		try {
			String strIdModelo = request.getParameter("id");
			Long idModelo = new ModeloService().grava(strIdModelo, request.getParameter("descricao"), 
					request.getParameter("marca"));
			String aviso = null;
			if (strIdModelo ==null ||  strIdModelo.trim().equals("")) {
				aviso=idModelo + " criado com sucesso";
			} else {
				aviso = idModelo +" alterado com sucesso";
			}
			
			request.setAttribute("msgAviso", "Modelo " + aviso );
			request.setAttribute("marcas" , new MarcaService().listaTodas());
			request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServiceException e) {
			throw new RuntimeException(e);
		}
		
	}

}
