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
@Table(name = "Servico")
@SequenceGenerator(name = Servico.SEQUENCE, sequenceName = Servico.SEQUENCE)
public class Servico extends Base{

	public static final String SEQUENCE = "SEQ_Servico";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IdServico")
	private Long idServico;

	@Column(name = "Descricao", length = 30)
	@Basic(optional = false)
	private String descricao;

	public Long getIdServico() {
		return this.idServico;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
