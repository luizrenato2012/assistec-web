package assistec.model.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.bean.Marca;
import assistec.model.bean.Modelo;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;
import assistec.util.ParametroPesquisaEquipamento;
import assistec.util.UtilAssistec;

public class EquipamentoService {
	
	/**altera ou inclui equipamento */
	public Long grava (String idStr , String descricao ,String strIdMarca,
			String strIdModelo,String strIdCliente,String observacao,
			String patrimonio,String numeroSerie) throws ServiceException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Equipamento>equipamentoDAO = new GenericHibernateDAO<Equipamento>(session);
			if(UtilAssistec.isVazia(descricao)) {
				throw new ServiceException("Descrição inválida");
			}
			Equipamento equipamento = null;
			if (UtilAssistec.isVazia(idStr)) {
				equipamento = new Equipamento();
			} else {
				Long id = Long.parseLong(idStr);
				equipamento = equipamentoDAO.search(id, Equipamento.class);
			}

			equipamento.setDescricao(descricao);
			equipamento.setObservacao(observacao);
			equipamento.setNumeroSerie(numeroSerie);
			equipamento.setPatrimonio(patrimonio);
			if ( !UtilAssistec.isVazia(strIdMarca)) {
				Long idMarca = Long.parseLong(strIdMarca);
				equipamento.setMarca(new GenericHibernateDAO<Marca>(session).search(idMarca, 
						Marca.class));
			}
			if ( !UtilAssistec.isVazia(strIdModelo)) {
				Long idModelo= Long.parseLong(strIdModelo);
				equipamento.setModelo(new GenericHibernateDAO<Modelo>(session).search(idModelo, 
						Modelo.class));
			}

			if ( !UtilAssistec.isVazia(strIdCliente)) {
				Long idCliente= Long.parseLong(strIdCliente);
				equipamento.setCliente(new GenericHibernateDAO<Cliente>(session).search(idCliente, 
						Cliente.class));
			}

			equipamentoDAO.saveUpdate(equipamento);
			session.getTransaction().commit();
			return equipamento.getId();
		} catch (Exception e) {
			if(session!=null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException(e);
		}
		
	}
	
	public List<Equipamento> lista() {
		throw new UnsupportedOperationException("Metodo nao implementado");
	}
	
	/** 
	 * pesquisa por equipamento com tipo de argumento variavel
	 * @throws ServiceException */
	public List<Equipamento> find (String tipoArgumento,String valor) throws ServiceException {
		String query = ParametroPesquisaEquipamento.getQuery(tipoArgumento);
		Session session=null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List<Equipamento> lista = new GenericHibernateDAO<Equipamento>(session).list(query, 
					tipoArgumento, valor+"%");
			session.getTransaction().commit();
			return lista!=null ? lista: new ArrayList<Equipamento>();
		} catch (Exception e ) {
			if(session!=null)
				session.getTransaction().rollback();
			throw new ServiceException(e);
		}
	}
	
	public Equipamento findById (String idStr) throws ServiceException {
		Session session=null;
		String query="from Equipamento eq join fetch eq.marca ma "+
					" join fetch eq.modelo mo "+
					" join fetch eq.cliente cl "+
					" where eq.id=:id";
		try {
			Long id = Long.parseLong(idStr);
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List<Equipamento> lista = new GenericHibernateDAO<Equipamento>(session).list(query, 
					"id", id);
			session.getTransaction().commit();
			return lista!=null ? lista.get(0): new Equipamento();
		} catch (Exception e ) {
			if(session!=null)
				session.getTransaction().rollback();
			throw new ServiceException(e);
		}
	}

}
