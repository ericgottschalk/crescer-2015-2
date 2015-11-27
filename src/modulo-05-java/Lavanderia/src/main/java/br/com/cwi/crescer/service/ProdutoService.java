package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.domain.Produto;

@Service
public class ProdutoService {

	private ProdutoDao dao;
	
	@Autowired
	public ProdutoService(ProdutoDao produtoDao){
		super();
		this.dao = produtoDao;
	}
}
