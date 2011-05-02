package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.service.ClienteService;
import assistec.model.service.ServiceException;
import assistec.util.UtilAssistec;


public class GravaCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		request.setAttribute("listUf", ListaUf.getLista());
		if ( UtilAssistec.isVazia( request.getParameter("nome") ) ){
			request.setAttribute("msgErro", "Nome inválido");
			request.getRequestDispatcher("cliente_pg.jsp").forward(request, response);
			return;
		} 
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String telefone = request.getParameter("telefone");
		
		String aviso = null;
		String paramId = request.getParameter("id");
		
			Long id = new ClienteService().gravaCliente(nome, endereco, 
					cidade, uf, telefone, paramId);
			aviso = (paramId==null ||  paramId.trim().equals("")) ?
					"Cliente " + id + " criado com sucesso" :
					"Cliente " + id +" alterado com sucesso";	
			request.setAttribute("msgAviso", "Cliente " + aviso );
			request.getRequestDispatcher("cliente_pg.jsp").forward(request, response);
		
	}

}
