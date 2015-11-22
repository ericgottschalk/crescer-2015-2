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
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE, sequenceName = Produto.SEQUENCE)
public class Produto extends Base{

	public static final String SEQUENCE = "SEQ_Produto";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IDProduto")
	private Long idProduto;

	@Column(name = "IDServico")
	@Basic(optional = false)
	private Long idServico;
	
	@Column(name = "IDMaterial")
	@Basic(optional = false)
	private Long idMaterial;
	
	@Column(name = "Valor", precision = 12, scale = 2)
	@Basic(optional = false)
	private Double valor;

	public Long getIdProduto() {
		return this.idProduto;
	}

	public Long getIdServico() {
		return this.idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Long getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}