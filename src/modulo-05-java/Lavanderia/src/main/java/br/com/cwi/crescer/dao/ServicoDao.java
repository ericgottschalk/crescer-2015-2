package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDao extends BaseDao<Servico>{
	
	public Servico findById(Long id){
    	return this.manager.find(Servico.class, id);
    }

	public List<Servico> find() {
		return this.manager.createQuery("FROM Servico", Servico.class).getResultList();
	}
}
