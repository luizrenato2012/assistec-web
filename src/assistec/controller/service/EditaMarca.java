package assistec.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.service.MarcaService;
import assistec.util.UtilAssistec;

public class EditaMarca  implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paramId = request.getParameter("id");
		if ( UtilAssistec.isVazia(paramId)) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/marca_pg.jsp").forward(request, response);
		} else {
			Marca marca = new MarcaService().seleciona(paramId);
			if ( marca==null) {
				throw new RuntimeException("Marca com id " + paramId+ " não encontrado");
			}
			request.setAttribute("marca", marca);
			request.getRequestDispatcher( "marca_pg.jsp").forward(request, response);
		}
		
	}

}
