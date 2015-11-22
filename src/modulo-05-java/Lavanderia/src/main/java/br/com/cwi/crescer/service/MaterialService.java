package br.com.cwi.crescer.service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.MaterialDao;
import br.com.cwi.crescer.domain.Material;

public class MaterialService {

	private MaterialDao dao;
	
	@Autowired
	public MaterialService(MaterialDao materialDao){
		this.dao = materialDao;
	}
	
	public Material findById(long id){
		return this.dao.findById(id);
	}
}
