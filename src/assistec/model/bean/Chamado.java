package assistec.model.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="assistec.chamado")
@SequenceGenerator(name="SEQ_CHAMADO",sequenceName="assistec.id_seq_chamado")
public class Chamado {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_CHAMADO")
	private Long id;
	private Date dataHoraAbertura ;
	private  Date dataHoraFechamento;
	private  String defeitoReclamado;
	private  String solicitante;
	private  Boolean situacao;
	private  String observacao;
	
	private  Cliente cliente;
	private  Equipamento equipamento;
	private List<Atendimento> atendimentos ;
}
