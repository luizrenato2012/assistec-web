package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.service.MarcaService;
import assistec.model.service.ModeloService;
import assistec.util.UtilAssistec;

public class ExibeModelo implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//lista com todas as marcas p/ escolha no cadastro de modelo
		List<Marca> marcas = new MarcaService().listaTodas();
		Modelo modelo=null;
		if ( UtilAssistec.isVazia( marcas))  {
			request.setAttribute("msgErro","Erro ao carregar lista de marcas");
		} else {
			request.setAttribute("marcas",marcas);
		}
		String paramId = request.getParameter("id") ;
		if (!UtilAssistec.isVazia(paramId)) {
			modelo = new ModeloService().seleciona(paramId);
			request.setAttribute("modelo",modelo);
		}
		request.getRequestDispatcher("/modelo_pg.jsp").forward(request, response);
	}

}
