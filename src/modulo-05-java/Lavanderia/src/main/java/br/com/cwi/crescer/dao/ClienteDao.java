package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDao extends BaseDao<Cliente>{

	public ClienteDao() {
		super(Cliente.class);
	}
}
