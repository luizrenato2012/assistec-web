package assistec.controller.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assistec.model.bean.Cliente;
import assistec.model.dao.GenericHibernateDAO;
import assistec.util.UtilAssistec;


public class GravaCliente implements ServiceITF {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("listUf", ListaUf.getLista());
		if ( UtilAssistec.isVazia( request.getParameter("nome") ) ){
			request.setAttribute("msgErro", "Nome inválido");
			try {
				request.getRequestDispatcher("cliente_pg.jsp").forward(request, response);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		} 
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String telefone = request.getParameter("telefone");
		GenericHibernateDAO<Cliente> dao = new GenericHibernateDAO<Cliente>(Cliente.class);
		
		Cliente cliente =null;
		Long id=null;
		String aviso = null;
		if ( request.getParameter("id")==null ||  request.getParameter("id").trim().equals("")) {
			cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setCidade(cidade);
			cliente.setUf(uf);
			cliente.setTelefone(telefone);
			id = dao.insert(cliente);
			aviso=id + " criado com sucesso";
		} else {
			id = Long.parseLong(request.getParameter("id"));
			cliente = dao.search(id);
			if ( cliente==null) {
				throw new RuntimeException("cliente inválido");
			}
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setCidade(cidade);
			cliente.setUf(uf);
			cliente.setTelefone(telefone);
			dao.update(cliente);
			aviso = id +" alterado com sucesso";
		}
		
		try {
			request.setAttribute("msgAviso", "Cliente " + aviso );
			request.getRequestDispatcher("cliente_pg.jsp").forward(request, response);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
