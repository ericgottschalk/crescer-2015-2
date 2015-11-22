package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.domain.Servico;

public class ServicoService {
	
	private ServicoDao dao;
	
	@Autowired
	public ServicoService(ServicoDao servicoDao){
		this.dao = servicoDao;
	}
	
	public Servico findById(long id){
		return this.dao.findById(id);
	}
}
