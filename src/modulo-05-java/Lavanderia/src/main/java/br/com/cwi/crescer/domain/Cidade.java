package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cwi.crescer.common.Base;

@Entity
@Table(name = "Cidade")
public class Cidade extends Base{

    @Id
    @Column(name = "IDCidade")
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

    public void setIdCidade(Long id) {
        this.idCidade = id;
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
