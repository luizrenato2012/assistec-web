package assistec.controller.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.service.ClienteService;
import assistec.util.UtilAssistec;

public class ExcluiCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paramId = request.getParameter("id") ;
		if ( UtilAssistec.isVazia( paramId) ){
			request.setAttribute("msgErro", "Id inválido");
			try {
				request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		ClienteService clienteService= new ClienteService();
		clienteService.exclui(paramId);
		request.setAttribute("msgAviso", "Cliente excluído com sucesso!");
		
		String argumento = request.getParameter("viewArg");
		System.out.println("viewArg " + argumento);
		
		List<Cliente> list = clienteService.pesquisaPorNome(argumento);
		if (list==null ) {
			System.out.println("Sem clientes ");
		} else {
			System.out.println("Quantidade de clientes " + list.size());
		}
		request.setAttribute("itens", list);
		request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
	}

}
