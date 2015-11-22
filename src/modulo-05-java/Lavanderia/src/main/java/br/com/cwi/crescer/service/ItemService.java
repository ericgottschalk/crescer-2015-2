package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.ItemDao;
import br.com.cwi.crescer.domain.Item;

public class ItemService {

	private ItemDao dao;
	
	@Autowired
	public ItemService(ItemDao itemDao){
		this.dao = itemDao;
	}
	
	public Item findById(long id){
		return this.dao.findById(id);
	}
}
