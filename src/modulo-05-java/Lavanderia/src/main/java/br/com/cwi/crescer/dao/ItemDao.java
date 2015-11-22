package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Item;

@Repository
public class ItemDao extends BaseDao<Item>{

	public ItemDao() {
		super(Item.class);
	}
}
