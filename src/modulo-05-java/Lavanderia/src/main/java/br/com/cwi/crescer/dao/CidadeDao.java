package br.com.cwi.crescer.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDao extends BaseDao<Cidade>{

	public CidadeDao() {
		super(Cidade.class);
	}

	public List<Cidade> find() {
		return this.manager.createQuery("FROM Cidade", this.classs).getResultList();
	}
}
