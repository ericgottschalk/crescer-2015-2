package br.com.cwi.crescer.dao;
import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDao extends BaseDao<Cidade>{

	public CidadeDao() {
		super(Cidade.class);
	}
}
