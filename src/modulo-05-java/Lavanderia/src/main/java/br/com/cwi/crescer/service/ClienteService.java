package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;

public class ClienteService {

	private ClienteDao dao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao){
		this.dao = clienteDao;
	}
	
	public Cliente findById(long id){
		return this.dao.findById(id);
	}
}
