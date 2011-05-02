package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.service.MarcaService;
import assistec.util.UtilAssistec;


public class GravaMarca implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws Exception  {
		if ( UtilAssistec.isVazia( request.getParameter("nome") ) ){
			request.setAttribute("msgErro", "Nome inválido");
			request.getRequestDispatcher("modelo_pg.jsp").forward(request, response);
			return;
		} 

		String nome = request.getParameter("nome");
		String idMarca = request.getParameter("id");
		String aviso = null;
		Long id = new MarcaService().grava(idMarca, nome);
		aviso= UtilAssistec.isVazia(idMarca) ? id + " criado com sucesso":
			id +" alterado com sucesso";

		request.setAttribute("msgAviso", "Marca " + aviso );
		request.getRequestDispatcher("marca_pg.jsp").forward(request, response);

	}

}
