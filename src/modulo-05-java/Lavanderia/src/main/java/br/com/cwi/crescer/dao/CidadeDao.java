package br.com.cwi.crescer.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDao extends BaseDao<Cidade>{

	public Cidade findById(Long id){
		return this.manager.find(Cidade.class, id);
	}
	
	public List<Cidade> find() {
		return this.manager.createQuery("FROM Cidade", Cidade.class).getResultList();
	}
}
