package br.com.cwi.crescer.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ClienteDto {

    public Long id;
    
    @NotBlank
    public String name;
    
    @NotBlank
    @Length(min = 11, max = 11)
    @CPF
    public String cpf;
    
    @NotBlank
    @Email
    public String email;
    
    public String endereco;
    public String bairro;
    public String cidade;
    public String uf;
    public String cep;
    public SituacaoCliente situacao;
    
    @NotNull
    public Long idCidade;

    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getIdCliente();
        this.name = cliente.getName();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.endereco = cliente.getEndereco();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade().getName();
        this.uf = cliente.getCidade().getUf();
        this.cep = cliente.getCep();
        this.situacao = cliente.getSituacao();
    }

    public boolean isUpdate() {
        return this.id != null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }
}
