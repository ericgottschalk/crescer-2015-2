package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Users;

@Repository
public class UserDao extends BaseDao<Users>{

	public List<Users> find(){
		return this.manager.createQuery("FROM users", Users.class).getResultList();
	}
	
	public List<Users> findByName(String name){
		return null;
	}

	public Users findByUsername(String id) {
		return this.manager.find(Users.class, id);
	}
}
