package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.domain.Cidade;

@Service
public class CidadeService {

	private CidadeDao dao;
	
	@Autowired
	public CidadeService(CidadeDao cidadeDao){
		super();
		this.dao = cidadeDao;
	}
	
	public Cidade findById(long id){		
		return this.dao.findById(id);
	}
}
