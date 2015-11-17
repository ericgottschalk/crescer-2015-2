package br.com.cwi.crescer;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.exception.ListException;

public class LinkedList<T> implements MyList<T> {

    protected Node<T> last, first;

    @Override
    public void add(int index, T value) {
        if (index == 0) {
            this.addFirst(value);
            return;
        }

        Node<T> novo = new Node<T>(value);
        Node<T> nodo = getNode(index - 1);
        Node<T> proximo = nodo.getNext();
        novo.setNext(proximo);
        nodo.setNext(novo);
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<>(value, first);

        if (isEmpty()) {
            this.last = node;
        }
        this.first = node;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<>(value);

        if (isEmpty()) {
            this.first = node;
        } else {
            this.last.setNext(node);
        }
        this.last = node;
    }

    @Override
    public void remove(int index) {
        if (index == 0 || isEmpty()) {
            this.removeFirst();
        } else {
            Node<T> actualNode = getNode(index);

            if (actualNode != null) {
                actualNode.setNext(actualNode.getNext().getNext());
            }
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            first = first.getNext();
        }
    }

    @Override
    public void removeLast() {

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
            list.add(node.getValue());
            node = node.getNext();
        }
        return list;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new ListException("A lista esta vazia");
        }
        return this.first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new ListException("A lista esta vazia");
        }
        return this.last.getValue();
    }

    public void printTxt() throws Exception {
        String newLine = "\r\n";
        try (Writer writer = new FileWriter(
                "C:\\Users\\eric.gottschalk\\Documents\\crescer15-2\\src\\modulo-05-java\\dia-01\\Listas\\src\\br\\com\\cwi\\crescer\\linked.txt")) {
            for (T element : this.listAll()) {
                writer.write(element.toString() + newLine);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Node<T> getNode(int index) {
        Node<T> node = first;
        if (index > 0) {
            for (int i = 1; i < index; i++) {
                if (node == null) {
                    return null;
                }
                node = node.getNext();
            }
        }
        return node;
    }

    protected class Node<E> {

        private E value;

        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }
}