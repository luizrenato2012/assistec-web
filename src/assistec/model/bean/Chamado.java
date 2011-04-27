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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataHoraAbertura() {
		return dataHoraAbertura;
	}
	public void setDataHoraAbertura(Date dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}
	public Date getDataHoraFechamento() {
		return dataHoraFechamento;
	}
	public void setDataHoraFechamento(Date dataHoraFechamento) {
		this.dataHoraFechamento = dataHoraFechamento;
	}
	public String getDefeitoReclamado() {
		return defeitoReclamado;
	}
	public void setDefeitoReclamado(String defeitoReclamado) {
		this.defeitoReclamado = defeitoReclamado;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public Boolean getSituacao() {
		return situacao;
	}
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}
	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
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
