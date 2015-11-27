package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao extends BaseDao<Produto>{

	public Produto findById(Long id){
    	return this.manager.find(Produto.class, id);
    }
}
