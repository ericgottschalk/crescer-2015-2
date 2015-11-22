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
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE, sequenceName = Cliente.SEQUENCE)
public class Cliente extends Base{

	public static final String SEQUENCE = "SEQ_Cliente";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
	@Column(name = "IDCliente")
	private Long idCliente;

	@Column(name = "Nome", length = 70)
	@Basic(optional = false)
	private String name;
	
	@Column(name = "CPF", length = 11)
	@Basic(optional = false)
	private String cpf;
	
	@Column(name = "Email", length = 100)
	private String email;

	@Column(name = "Endereco", length = 50)
	private String endereco;
	
	@Column(name = "Bairro", length = 50)
	private String bairro;
	
	@Column(name = "IDCidade")
	private Long idCidade;
	
	@Column(name = "CEP", length = 8)
	private int cep;
	
	@Column(name = "Situacao")
	private Character situacao;

	public Long getIdCliente() {
		return this.idCliente;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public int getCep() {
		return this.cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}
}