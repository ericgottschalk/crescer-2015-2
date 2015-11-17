package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.cwi.crescer.DoublyLinkedList;

public class DoublyLinkedListTest {
	
	@Test
	public void inserirPrimeiro(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("value");
		
		assertEquals(list.getFirst(), "value");
	}
	
	@Test
	public void inserirUltimo(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		
		assertEquals(list.getFirst(), "first");
		assertEquals(list.getLast(), "last");
	}
	
	@Test
	public void inserirMeio(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		
		list.add(3, "tres");
		assertTrue(list.contains("tres"));
		
	}
	
	@Test
	public void removerPrimeiro(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
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
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.addFirst("value0");
		list.addFirst("value1");
		list.addFirst("value2");
		list.addLast("last");
		list.addFirst("first");
		list.remove(4);
		
		assertFalse(list.contains("last"));
	}
}
