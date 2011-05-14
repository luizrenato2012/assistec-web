package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import assistec.model.bean.Chamado;
import assistec.model.service.ChamadoService;
import assistec.util.UtilAssistec;

public class PesquisaChamado implements ServiceITF {
	
	private Log log = LogFactory.getLog(PesquisaChamado.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String tipo = request.getParameter("tipoArgumento");
		String argumento = request.getParameter("argumento");
		
		if (UtilAssistec.isVazia(tipo)) {
			request.setAttribute("msgErro", "Tipo de pesquisa inválido");
			request.getRequestDispatcher("pesquisa/chamado_pg.jsp").forward(request,response);
		}
		
		if (UtilAssistec.isVazia(argumento)) {
			request.setAttribute("msgErro", "Valor digitado inválido");
			request.getRequestDispatcher("pesquisa/chamado_pg.jsp").forward(request,response);
		}
		log.info("tipo " + tipo + " argumento " + argumento);
		List<Chamado> listaChamado=new ChamadoService().pesquisa(tipo,argumento);
		if ( UtilAssistec.isVazia(listaChamado)) {
			request.setAttribute("msgAviso", "Não foram encontrados chamados");
		} else {
			request.setAttribute("listaChamado",listaChamado);
		}
		request.getRequestDispatcher("pesquisa/chamado_pg.jsp").forward(request,response);
		
	}

}
