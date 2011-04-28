package assistec.model.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import assistec.model.bean.Chamado;
import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;
import assistec.util.UtilAssistec;

public class ChamadoService {
	
	/**
	 * 
	 * @param dataHora
	 * @param solicitante
	 * @param defeito
	 * @param observacao
	 * @param idEquipamento
	 * @param idCliente
	 * @throws ServiceException
	 */
	public void abreChamado(String dataHora,String solicitante,String defeito,String observacao,
			String strIdEquipamento,String strIdCliente) throws ServiceException {
		if ( UtilAssistec.isVazia(strIdCliente)) {
			throw new ServiceException ("Sem cliente informado");
		}
		Date data = null;
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Long idEquipamento = null;
		Long idCliente = null;
		Session session = null;
		try {
			data= fmt.parse(dataHora);
			idCliente = Long.parseLong(strIdCliente);
			idEquipamento = Long.parseLong(strIdEquipamento);
			Chamado chamado = new Chamado();
			chamado.setDataHoraAbertura(data);
			chamado.setSolicitante(solicitante);
			chamado.setObservacao(observacao);
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			GenericHibernateDAO<Equipamento> equipamentoDao = new GenericHibernateDAO<Equipamento>(session);
			chamado.setEquipamento(equipamentoDao.search(idEquipamento,Equipamento.class));
			
			GenericHibernateDAO<Cliente> clienteDao = new GenericHibernateDAO<Cliente>(session);
			chamado.setCliente(clienteDao.search(idCliente,Cliente.class));
			chamado.setSituacao(true);
			session.save(chamado);
			session.getTransaction().commit();
		} catch (ParseException e) {
			throw new ServiceException("Erro ao informar data" , e);
		} catch (Exception e ) {
			if(session != null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException("Erro ao gravar chamado",e);
			}
		}
		

}
