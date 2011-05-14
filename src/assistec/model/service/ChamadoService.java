package assistec.model.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import assistec.model.bean.Chamado;
import assistec.model.bean.Cliente;
import assistec.model.bean.Equipamento;
import assistec.model.dao.GenericHibernateDAO;
import assistec.model.dao.HibernateUtil;
import assistec.util.ParametroPesquisaChamado;
import assistec.util.UtilAssistec;

public class ChamadoService {
	
	private static Log log = LogFactory.getLog(ChamadoService.class);
	
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
	public Long abreChamado(String dataHora,String solicitante,String defeito,String observacao,
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
			idEquipamento = !UtilAssistec.isVazia(strIdEquipamento)  ? 
					Long.parseLong(strIdEquipamento) : null;
			Chamado chamado = new Chamado();
			chamado.setDataHoraAbertura(data);
			chamado.setAberto(true);
			chamado.setObservacao(observacao);
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			if (idEquipamento!=null) {
				GenericHibernateDAO<Equipamento> equipamentoDao = new GenericHibernateDAO<Equipamento>(session);
				chamado.setEquipamento(equipamentoDao.search(idEquipamento,Equipamento.class));
			}
			
			GenericHibernateDAO<Cliente> clienteDao = new GenericHibernateDAO<Cliente>(session);
			chamado.setCliente(clienteDao.search(idCliente,Cliente.class));
			chamado.setSolicitante(solicitante);
			session.save(chamado);
			session.getTransaction().commit();
			return chamado.getId();
		} catch (ParseException e) {
			throw new ServiceException("Erro ao informar data" , e);
		} catch (Exception e ) {
			if(session != null) {
				session.getTransaction().rollback();
			}
			throw new ServiceException("Erro ao abrir chamado ",e);
			}
		}
	
	/** 
	 * pesquisa por equipamento com tipo de argumento variavel
	 * @throws ServiceException 
	 */
	public List<Chamado> pesquisa (String tipoArgumento,String valor) throws ServiceException {
		String query = ParametroPesquisaChamado.getQuery(tipoArgumento); 
		Session session=null;
		// parametros p/ query's like 
		String paramLike = "numeroSerie,patrimonio,cliente";
		List<Chamado> lista =null;
		log.info("tipoArgumento " + tipoArgumento + " valor " + valor);
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			if ("id".equalsIgnoreCase(tipoArgumento)) {
				Long id = Long.parseLong(valor);
				lista= new GenericHibernateDAO<Chamado>(session).list(query, 
						tipoArgumento, id);
			} else if ("dataHoraAbertura".equalsIgnoreCase(tipoArgumento)) {
				Date dataAbertura = DateFormat.getDateInstance().parse(valor);
				lista = new GenericHibernateDAO(session).list(query, tipoArgumento, 
						dataAbertura);
			}else {
				//pesquisa por outros campos
				valor = paramLike.indexOf(tipoArgumento)==-1 ? valor : valor +"%";
				lista= new GenericHibernateDAO<Chamado>(session).list(query, 
						tipoArgumento, valor);
			}
			session.getTransaction().commit();
			return lista!=null ? lista: new ArrayList<Chamado>();
		} catch (Exception e ) {
			e.printStackTrace();
			if(session!=null)
				session.getTransaction().rollback();
			throw new ServiceException(e);
		}
	}
	
	public Chamado seleciona (String paramId) throws ServiceException {
		Session session=null;
		try {
			Long id = Long.parseLong(paramId);
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Chamado chamado= new GenericHibernateDAO<Chamado>(session).search(id, Chamado.class);
			session.getTransaction().commit();
			return chamado;
		} catch (Exception e ) {
			if(session!=null)
				session.getTransaction().rollback();
			throw new ServiceException(e);
		}	
	}
	
	public static void main(String[] args) {
	}
	
	
	static void testePesquisa() {
		try {
			List<Chamado> lista = new ChamadoService().pesquisa("id", "5");
			if (UtilAssistec.isVazia(lista)) {
				System.out.println("Sem chamados");
			} else {
				for(Chamado chamado : lista) {
					System.out.println(chamado);
					System.out.println(chamado.getCliente().getNome());
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	

}
