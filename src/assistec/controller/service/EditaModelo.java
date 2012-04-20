package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.service.MarcaService;
import assistec.model.service.ModeloService;
import assistec.util.UtilAssistec;

/**
 * Realiza alteracçoes num modelo
 * @author renato
 *
 */
public class EditaModelo  implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		GenericHibernateDAO<Modelo> dao = new GenericHibernateDAO<Modelo>(Modelo.class);
		String paramId = request.getParameter("id");
		if ( UtilAssistec.isVazia(paramId)) {
			request.setAttribute("msgErro", "id selecionado inválido");
			request.getRequestDispatcher("pesquisa/modelo_pg.jsp").forward(request, response);
		} else {
			Modelo modelo = new ModeloService().seleciona(paramId);
			if ( modelo==null) {
				throw new RuntimeException("Modelo com id " + paramId+ " não encontrado");
			}
			List<Marca> marcas = new MarcaService().listaTodas();
			request.setAttribute("modelo", modelo);
			request.setAttribute("marcas", marcas);
			request.getRequestDispatcher( "modelo_pg.jsp").forward(request, response);
		}
		
	}

}
