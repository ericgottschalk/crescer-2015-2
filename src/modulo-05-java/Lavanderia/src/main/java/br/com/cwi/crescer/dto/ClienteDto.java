package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ClienteDto {

    public Long id;
    public String name;
    public String cpf;
    public String email;
    public String endereco;
    public String bairro;
    public String cidade;
    public String uf;
    public String cep;
    public SituacaoCliente situacao;
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
        this.uf = cliente.getCep();
        this.cep = cliente.getCep();
        this.situacao = cliente.getSituacao();
    }

    public boolean isUpdate() {
        return this.id != null;
    }

    public Long getId() {
        return id;
    }
}
