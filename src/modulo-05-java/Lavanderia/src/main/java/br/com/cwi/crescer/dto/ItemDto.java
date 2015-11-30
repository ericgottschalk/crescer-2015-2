package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDto {

	private Long idItem;

	private Long idPedido;
	
	@NotNull
	private Long idProduto;
	
	@NotNull
	private Double peso;
	
	private BigDecimal valor;
	
	private BigDecimal valorTotal;
	
	private SituacaoItem situacao;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoItem getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
}
