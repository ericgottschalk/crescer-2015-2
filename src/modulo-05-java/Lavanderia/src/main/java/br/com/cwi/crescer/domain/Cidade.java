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
@Table(name = "Cidade")
@SequenceGenerator(name = Cidade.SEQUENCE, sequenceName = Cidade.SEQUENCE)
public class Cidade extends Base{

	public static final String SEQUENCE = "SEQ_Cidade";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IdCidade")
	private Long idCidade;
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String name;
	
	@Column(name = "UF", length = 2)
	@Basic(optional = false)
	private String uf;

	public Long getIdCidade() {
		return this.idCidade;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
