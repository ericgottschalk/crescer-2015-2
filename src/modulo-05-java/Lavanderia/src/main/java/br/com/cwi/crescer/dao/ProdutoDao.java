package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao extends BaseDao<Produto>{

	public ProdutoDao() {
		super(Produto.class);
	}
}
