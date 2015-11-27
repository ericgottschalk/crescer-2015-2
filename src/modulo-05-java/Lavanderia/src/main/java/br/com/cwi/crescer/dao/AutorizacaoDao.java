package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Authorities;

@Repository
public class AutorizacaoDao extends BaseDao<Authorities>{

	public Authorities findByUsername(String username) {
		return this.manager.find(Authorities.class, username);
	}
}
