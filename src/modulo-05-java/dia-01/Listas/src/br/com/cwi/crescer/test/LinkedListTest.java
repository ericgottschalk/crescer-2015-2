package br.com.cwi.crescer.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;
import br.com.cwi.crescer.MyList;

public class LinkedListTest {
	
	@Test
	public void inserirPrimeiro(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("value");
		
		assertEquals(list.getFirst(), "value");
	}
	
	@Test
	public void inserirUltimo(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		
		assertEquals(list.getFirst(), "first");
		assertEquals(list.getLast(), "last");
	}
	
	//@Test
	//public void inserirMeio(){
	//LinkedList<String> list = new LinkedList<String>();
	//list.addFirst("value0");
	//list.addFirst("value1");
	//list.addFirst("value2");
	//list.addLast("last");
	//list.addFirst("first");
		
	//list.add(3, "tres");
	//assertTrue(list.contains("tres"));
		
	//}
	
	@Test
	public void removerPrimeiro(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		list.removeFirst();
		
		assertFalse(list.getFirst() == "first");
	}
	
	@Test
	public void removerMeio(){
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		list.remove(4);
		
		assertFalse(list.contains("last"));
	}
}
