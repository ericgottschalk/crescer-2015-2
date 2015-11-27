package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDao extends BaseDao<Material>{
	
	public Material findById(Long id){
    	return this.manager.find(Material.class, id);
    }
}
