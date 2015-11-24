package br.com.cwi.crescer.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Item;

public class ItemDaoTest extends AbstractInfraTest{

	@Autowired
	private ItemDao dao;
	
	@Test
	public void buscarPorId(){
	    Item item = this.dao.findById(1L);
	    assertNotNull(item);
	    assertNotNull(item.getPedido());
	    assertNotNull(item.getProduto());
	}
}
