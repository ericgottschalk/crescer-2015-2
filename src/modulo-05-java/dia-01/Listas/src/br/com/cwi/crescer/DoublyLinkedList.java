package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.LinkedList.Node;
import br.com.cwi.exception.ListException;

public class DoublyLinkedList<T> implements MyList<T>{

	private Node<T> first, last;
	
	public void add(int index, T value) {
		Node<T> novo = new Node<T>();
		novo.value = value;
        Node<T> nodo = getNode(index);
        Node<T> prevoius = nodo.previous;
        Node<T> next = nodo.next;

        prevoius.next = novo;
        next.previous = novo;

        novo.previous = nodo.previous;
        novo.next = nodo;
	}

	public void addFirst(T value) {
		Node<T> node = new Node<T>();
		node.value = value;

        if (isEmpty()) {
            this.last = node;
        }else{
        	node.next = this.first;
        }
        this.first = node;		
	}

	public void addLast(T value) {
		Node<T> node = new Node<T>();
		node.value = value;

        if (isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
        }
        this.last = node;
	}

	public void remove(int index) {
		Node<T> removed = getNode(index);
        Node<T> previous = removed.previous;
        previous.next = removed.next;
	}

	public void removeFirst() {
		if (!isEmpty()){
			this.first = this.first.next;
		}
	}

	public void removeLast() {
		// TODO Auto-generated method stub
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public boolean contains(T value) {
		Node<T> node = this.first;
    	while(node != null){
    		if (node.value == value){
    			return true;
    		}
    	}

    	return false;
	}

	public List<T> listAll() {
		ArrayList<T> list = new ArrayList<>();
        Node<T> node = first;

        while (node != null) {
            list.add(node.value);
            node = node.next;
        }
        return list;
	}
	
	private Node<T> getNode(int index) {
        Node<T> node = first;
        if (index > 0) {
            for (int i = 1; i < index; i++) {
                if (node == null) {
                    return null;
                }
                node = node.next;
            }
        }
        return node;
    }
	
	public T getFirst() {
        if (isEmpty()) {
            throw new ListException("A lista esta vazia");
        }
        return this.first.value;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new ListException("A lista esta vazia");
        }
        return this.last.value;
    }
	
	private class Node<E> {

		public E value;

        public Node<E> next, previous;
    }
}
