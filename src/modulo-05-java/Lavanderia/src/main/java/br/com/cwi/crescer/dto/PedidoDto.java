package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDto {

	@NotNull
	private Long idPedido;

	@NotNull
	private Long idCliente;
	private Cliente cliente;
	
	private Date dataInclusao;
	
	private Date dataEntrega;
	
	private BigDecimal valorBruto;
	
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	private SituacaoPedido situacao;
	
	public List<Item> itens;
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
