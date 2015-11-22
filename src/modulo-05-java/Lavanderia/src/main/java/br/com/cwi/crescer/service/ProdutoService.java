package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoService {

	private ProdutoDao dao;
	
	@Autowired
	public ProdutoService(ProdutoDao produtoDao){
		this.dao = produtoDao;
	}
	
	public Produto findById(long id){
		return this.dao.findById(id);
	}
}
