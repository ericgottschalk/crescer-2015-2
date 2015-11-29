package br.com.cwi.crescer.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE, sequenceName = Pedido.SEQUENCE)
public class Pedido extends Base{

    public static final String SEQUENCE = "SEQ_Pedido";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @Column(name = "IDPEDIDO")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "IDCLIENTE")
    @Basic(optional = false)
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATAINCLUSAO")
    @Basic(optional = false)
    private Date dataInclusao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATAENTREGA")
    private Date dataEntrega;

    @Column(name = "VALORBRUTO", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valorBruto;

	@Column(name = "VALORFINAL", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valorTotal;
    
    @Column(name = "VALORDESCONTO", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valorDesconto;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao")
    private SituacaoPedido situacao;
    
    @OneToMany(mappedBy = "pedido")
	public List<Item> itens;

    public enum SituacaoPedido {
        PENDENTE, PROCESSANDO, PROCESSADO, ENCERRADO, CANCELADO
    }

    public Long getIdPedido() {
        return this.idPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public SituacaoPedido getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
    
    public List<Item> getItens() {
		return itens;
	}
    
    public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}