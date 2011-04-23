package assistec.controller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Equipamento;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;

public class PesquisaEquipamento implements ServiceITF {
	
	Map<String,String> mapParamQuery;
	
	public PesquisaEquipamento() {
		mapParamQuery = new HashMap<String,String>();
		mapParamQuery.put("descricao", "From Equipamento where descricao like :descricao ");
		mapParamQuery.put("marca","From Equipamento where marca.nome like :marca");
		mapParamQuery.put("modelo", "From Equipamento where modelo.descricao like :modelo");
		mapParamQuery.put("numeroSerie", "From Equipamento where numeroSerie like :numeroSerie");
		mapParamQuery.put("patrimonio", "From Equipamento where patrimonio like :patrimonio");
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String tipo = request.getParameter("tipoArgumento");
		if( !mapParamQuery.containsKey(tipo)) {
			throw new RuntimeException("Argumento de pesquisa "+ tipo +" inválido");
		}
//		System.out.println("tipo " + tipo);
		String argumento = request.getParameter("argumento")+"%";
//		System.out.println("argumento "+ argumento);
		List<Equipamento> listaEquipamento =new GenericHibernateDAO<Equipamento>(
				Equipamento.class).list( mapParamQuery.get(tipo),tipo,argumento);
		
		if ( UtilAssistec.isVazia(listaEquipamento)) {
			request.setAttribute("msgAviso", "Não foram encontrados equipamentos");
		} else {
			request.setAttribute("listaEquipamento", listaEquipamento);
		}
		request.getRequestDispatcher("pesquisa/equipamento_pg.jsp").forward(request, response);
		
	}

}
