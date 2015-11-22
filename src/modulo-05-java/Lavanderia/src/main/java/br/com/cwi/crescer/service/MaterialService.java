package br.com.cwi.crescer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDao;
import br.com.cwi.crescer.domain.Material;

@Service
public class MaterialService {

	private MaterialDao dao;
	
	@Autowired
	public MaterialService(MaterialDao materialDao){
		super();
		this.dao = materialDao;
	}
	
	public Material findById(long id){
		return this.dao.findById(id);
	}
}
