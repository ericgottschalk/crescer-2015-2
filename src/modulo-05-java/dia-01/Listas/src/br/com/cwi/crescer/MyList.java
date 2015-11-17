package br.com.cwi.crescer;

import java.util.List;

public interface MyList<T> {
	
	void add(int index, T value);
	void addFirst(T value);
	void addLast(T value);
	void remove(int index);
	void removeFirst();
	void removeLast();
	boolean isEmpty();
	boolean contains(T value);
	List<T> listAll();
}
