package br.com.cwi.crescer.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE, sequenceName = Pedido.SEQUENCE)
public class Pedido extends Base{

	public static final String SEQUENCE = "SEQ_Pedido";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IDPedido")
	private Long idPedido;
	
	@Column(name = "IDCliente")
	@Basic(optional = false)
	private Long idCliente;
	
	@Column(name = "DataInclusao")
	@Basic(optional = false)
	private Date dataInclusao;
	
	@Column(name = "DataEntrega")
	private Date dataEntrega;
	
	@Column(name = "Valor", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valor;

	@Column(name = "Situacao")
	private Character situacao;

	public Long getIdPedido() {
		return this.idPedido;
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
}