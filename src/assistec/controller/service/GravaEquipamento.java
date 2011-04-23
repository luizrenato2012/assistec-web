package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;


public class GravaEquipamento implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if ( UtilAssistec.isVazia( request.getParameter("descricao") ) ){
			request.setAttribute("msgErro", "Descriçao inválida");
			try {
				request.getRequestDispatcher("equipamento_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		
		String descricao = request.getParameter("descricao");
		String strMarca = request.getParameter("marca");
		String strModelo = request.getParameter("modelo");
		String strCliente= request.getParameter("cliente");
		String numeroSerie = request.getParameter("numeroSerie");
		String patrimonio = request.getParameter("patrimonio");
		GenericHibernateDAO<Equipamento> dao = new GenericHibernateDAO<Equipamento>(Equipamento.class);
		
		Equipamento equipamento =null;
		Long id=null;
		String aviso = null;
		Marca marca = null;
		Modelo modelo = null;
		Cliente cliente = null;
		
		if (!UtilAssistec.isVazia(strMarca)) {
			marca = new GenericHibernateDAO<Marca>(Marca.class).search( Long.parseLong(strMarca));
		}
		
		if (!UtilAssistec.isVazia(strModelo)) {
			modelo= new GenericHibernateDAO<Modelo>(Modelo.class).search(Long.parseLong(strModelo));
		}
		
		if (!UtilAssistec.isVazia(strCliente)) {
			cliente= new GenericHibernateDAO<Cliente>(Cliente.class).search( Long.parseLong(strCliente));
		}
		
		if ( request.getParameter("id")==null ||  request.getParameter("id").trim().equals("")) {
			equipamento = new Equipamento();
			equipamento.setDescricao(descricao);
			equipamento.setMarca(marca);
			equipamento.setModelo(modelo);
			equipamento.setNumeroSerie(numeroSerie);
			equipamento.setPatrimonio(patrimonio);
			equipamento.setCliente(cliente);
			id = dao.insert(equipamento);
			aviso=id + " criado com sucesso";
		} else {
			id = Long.parseLong(request.getParameter("id"));
			equipamento = dao.search(id);
			if ( equipamento==null) {
				throw new RuntimeException("equipamento inválido");
			}
			equipamento.setDescricao(descricao);
			equipamento.setMarca(marca);
			equipamento.setModelo(modelo);
			equipamento.setNumeroSerie(numeroSerie);
			equipamento.setPatrimonio(patrimonio);
			equipamento.setCliente(cliente);
			dao.update(equipamento);
			aviso = id +" alterado com sucesso";
		}
		
		try {
			request.setAttribute("msgAviso", "Equipamento " + aviso );
			request.getRequestDispatcher("executa?operacao=ExibeEquipamento").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
