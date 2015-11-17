package br.com.cwi.crescer;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.exception.ListException;

public class DoublyLinkedList<T> implements MyList<T> {

    private Node<T> first, last;

    @Override
    public void add(int index, T value) {
        if (index == 0) {
            this.addFirst(value);
            return;
        }

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

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>();
        node.value = value;

        if (isEmpty()) {
            this.last = node;
        } else {
            node.next = this.first;
        }
        this.first = node;
    }

    @Override
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

    @Override
    public void remove(int index) {
        if (index == 0) {
            this.removeFirst();
            return;
        }
        Node<T> removed = getNode(index);
        Node<T> previous = removed.previous;
        previous.next = removed.next;
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            this.first = this.first.next;
        }
    }

    @Override
    public void removeLast() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = this.first;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
        }

        return false;
    }

    @Override
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

    public void printTxt() throws Exception {
        String newLine = "\r\n";
        try (Writer writer = new FileWriter(
                "C:\\Users\\eric.gottschalk\\Documents\\crescer15-2\\src\\modulo-05-java\\dia-01\\Listas\\src\\br\\com\\cwi\\crescer\\doubly.txt")) {
            for (T element : this.listAll()) {
                writer.write(element.toString() + newLine);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
