package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.service.MarcaService;
import assistec.util.UtilAssistec;

public class ExcluiMarca implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paramId = request.getParameter("id") ;
		if ( UtilAssistec.isVazia( paramId) ){
			request.setAttribute("msgErro", "Id inválido");
				request.getRequestDispatcher("pesquisa/cliente_pg.jsp").forward(request, response);
				return;
		} 
		request.setAttribute("msgAviso", "Marca excluída com sucesso!");
		MarcaService marcaService = new MarcaService();
		String argumento = request.getParameter("viewArg");
		System.out.println("viewArg " + argumento);
		List<Marca> list = marcaService.listaNome(argumento);
//		List<Marca> list = dao.list("%"+argumento+"%", "nome");
		request.setAttribute("itens", list);
		request.getRequestDispatcher("pesquisa/marca_pg.jsp").forward(request, response);
	}

}
