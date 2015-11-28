package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;

public class ProdutoDto {

    @NotBlank
    private Long idMaterial;

    @NotBlank
    private Long idServico;

    @NotBlank
    private BigDecimal valor;

    @NotBlank
    private int prazo;

    private SituacaoProduto situacao;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public SituacaoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao = situacao;
    }
}
