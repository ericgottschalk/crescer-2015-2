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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE, sequenceName = Produto.SEQUENCE)
public class Produto extends Base{

    public static final String SEQUENCE = "SEQ_Produto";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @Column(name = "IDProduto")
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "IDServico")
    @Basic(optional = false)
    public Servico servico;

    @ManyToOne
    @JoinColumn(name = "IDMaterial")
    @Basic(optional = false)
    public Material material;

    @Column(name = "Valor", precision = 12, scale = 2)
    @Basic(optional = false)
    private BigDecimal valor;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao")
    @Basic(optional = false)
    private SituacaoProduto situacao;

    @Column(name = "prazo")
    @Basic(optional = false)
    private int prazo;

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public enum SituacaoProduto {
        ATIVO, INATIVO
    }

    public Long getIdProduto() {
        return this.idProduto;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }
}