package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao extends BaseDao<Cliente>{

    public List<Cliente> find(){
        return this.manager.createQuery("FROM Cliente", Cliente.class).getResultList();
    }
    
    public List<Cliente> findByName(String name){
        return this.manager.createQuery("SELECT c FROM Cliente c WHERE UPPER(c.name) LIKE :nome", Cliente.class)
        		.setParameter("nome", name.toUpperCase()+"%")
        		.getResultList();
    }
    
    public Cliente findById(Long id){
    	return this.manager.find(Cliente.class, id);
    }

	public List<Cliente> findAtivos() {
		return this.manager.createQuery("SELECT c FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
        		.setParameter("situacao", SituacaoCliente.ATIVO)
        		.getResultList();
	}
}
