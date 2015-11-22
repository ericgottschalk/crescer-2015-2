package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDao extends BaseDao<Servico>{

	public ServicoDao() {
		super(Servico.class);
	}
}
