package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.domain.Servico;

@Service
public class ServicoService {
	
	private ServicoDao dao;
	
	@Autowired
	public ServicoService(ServicoDao servicoDao){
		super();
		this.dao = servicoDao;
	}
	
	public Servico findById(long id){
		return this.dao.findById(id);
	}
}
