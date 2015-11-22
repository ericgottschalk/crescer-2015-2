package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeService {

	private CidadeDao dao;
	
	@Autowired
	public CidadeService(CidadeDao cidadeDao){
		this.dao = cidadeDao;
	}
	
	public Cidade findById(long id){		
		return this.dao.findById(id);
	}
}
