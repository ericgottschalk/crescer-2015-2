package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDao;
import br.com.cwi.crescer.domain.Item;

@Service
public class ItemService {

	private ItemDao dao;
	
	@Autowired
	public ItemService(ItemDao itemDao){
		super();
		this.dao = itemDao;
	}
}
