package br.com.cwi.crescer.domain;

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
@Table(name = "Item")
@SequenceGenerator(name = Item.SEQUENCE, sequenceName = Item.SEQUENCE)
public class Item extends Base{

	public static final String SEQUENCE = "SEQ_Item";	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IdItem")
	private Long idItem;
	
	@Column(name = "IdPedido")
	@Basic(optional = false)
	private Long idPedido;
	
	@Column(name = "IdProduto")
	@Basic(optional = false)
	private Long idProduto;
	
	@Column(name = "Peso", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double peso;
	
	@Column(name = "ValorUnitario", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valor;
	
	@Column(name = "ValorDeconto", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valorDesconto;
	
	@Column(name = "ValorTotal", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valorTotal;

	@Column(name = "Situacao")
	private Character situacao;

	public Long getIdItem() {
		return this.idItem;
	}

	public Long getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
}