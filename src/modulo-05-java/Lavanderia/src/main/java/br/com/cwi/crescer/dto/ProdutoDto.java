package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;

public class ProdutoDto {

	public Long idProduto;
	
    public Long idMaterial;
    
	public Material material;

    public Long idServico;

    public Servico servico;

    @NotNull
	public BigDecimal valor;

    @NotNull
    public int prazo;

    public SituacaoProduto situacao;

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
    
    public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
    public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
