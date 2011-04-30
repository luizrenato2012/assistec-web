package assistec.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="assistec.Atendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date data;
	private Date horaInicial;
	private Date horaFinal;
	private String descricao;
	private String defeitoConstatado;
	private String observacao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tecnico")
	private Tecnico tecnico;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="id_chamado")
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

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date dataHoraInicial) {
		this.horaInicial = dataHoraInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date dataHoraFinal) {
		this.horaFinal = dataHoraFinal;
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
