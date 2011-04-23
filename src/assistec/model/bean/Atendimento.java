package assistec.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_ATENDIMENTO",sequenceName="assistec.id_seq_atendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_ATENDIMENTO")
	private Long id;
	private Date data ;
	private Date dataHoraInicial;
	private Date dataHoraFinal;
	private String descricao;
	private String defeitoConstatado;
	private String observacao;
	
	private Tecnico tecnico;
	private Chamado chamado;
	
	public Atendimento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataHoraInicial() {
		return dataHoraInicial;
	}

	public void setDataHoraInicial(Date dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	public Date getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(Date dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public String getDefeitoConstatado() {
		return defeitoConstatado;
	}

	public void setDefeitoConstatado(String defeitoConstatado) {
		this.defeitoConstatado = defeitoConstatado;
	}
	
	
	
}
