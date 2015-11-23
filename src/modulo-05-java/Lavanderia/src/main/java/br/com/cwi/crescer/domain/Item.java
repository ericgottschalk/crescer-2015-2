package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Column(name = "IDItem")
    private Long idItem;

    @Column(name = "IDPedido")
    @Basic(optional = false)
    private Long idPedido;

    @Column(name = "IDProduto")
    @Basic(optional = false)
    private Long idProduto;

    @Column(name = "Peso", precision = 12, scale = 2)
    @Basic(optional = false)
    private Double peso;

    @Column(name = "ValorUnitario", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valor;

    @Column(name = "ValorDeconto", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valorDesconto;

    @Column(name = "ValorTotal", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao")
    private SituacaoItem situacao;

    public enum SituacaoItem {
        PENDENTE, PROCESSANDO, PROCESSADO
    }

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

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorDesconto() {
        return this.valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public SituacaoItem getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoItem situacao) {
        this.situacao = situacao;
    }
}