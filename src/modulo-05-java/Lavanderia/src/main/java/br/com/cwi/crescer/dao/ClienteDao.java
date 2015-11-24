package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDao extends BaseDao<Cliente>{

    public ClienteDao() {
        super(Cliente.class);
    }

    public List<Cliente> find(){
        return this.manager.createQuery("FROM Cliente", this.classs).getResultList();
    }
}
