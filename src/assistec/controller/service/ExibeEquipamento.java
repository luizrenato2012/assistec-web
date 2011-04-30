package assistec.controller.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.bean.Marca;
import assistec.model.service.ClienteService;
import assistec.model.service.EquipamentoService;
import assistec.model.service.MarcaService;

public class ExibeEquipamento implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String paramId = request.getParameter("id");
		if ( paramId!=null) {
			Equipamento equipamento = new EquipamentoService().selecionaPorId(paramId);
			if ( equipamento==null) {
				throw new RuntimeException("Cliente com id " + paramId+ " não encontrado");
			}
			request.setAttribute("equipamento", equipamento);
		} 
		
		List<Marca> listaMarca = new MarcaService().listaTodas();
		request.setAttribute("listaMarca", listaMarca);
		List<Cliente>listaCliente = new ClienteService().listaTodos();
		request.setAttribute("listaCliente", listaCliente);
		request.getRequestDispatcher( "equipamento_pg.jsp").forward(request, response);
	}

}
