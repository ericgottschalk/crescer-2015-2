package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDao extends BaseDao<Material>{
	
	public Material findById(Long id){
    	return this.manager.find(Material.class, id);
    }

	public List<Material> find() {
		return this.manager.createQuery("FROM Material", Material.class).getResultList();
	}
}
