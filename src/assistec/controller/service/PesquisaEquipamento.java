package assistec.controller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Equipamento;
import assistec.model.service.EquipamentoService;
import assistec.util.UtilAssistec;

public class PesquisaEquipamento implements ServiceITF {
	
	Map<String,String> mapParamQuery;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String tipo = request.getParameter("tipoArgumento");
		String argumento = request.getParameter("argumento");
			
		List<Equipamento> listaEquipamento =new EquipamentoService().find(tipo,	argumento);
		
		if ( UtilAssistec.isVazia(listaEquipamento)) {
			request.setAttribute("msgAviso", "Não foram encontrados equipamentos");
		} else {
			request.setAttribute("listaEquipamento", listaEquipamento);
		}
		request.getRequestDispatcher("pesquisa/equipamento_pg.jsp").forward(request, response);
		
	}

}
