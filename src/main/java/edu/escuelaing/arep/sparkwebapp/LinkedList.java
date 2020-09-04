package edu.escuelaing.arep.sparkwebapp;

import edu.escuelaing.arep.sparkwebapp.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *Data structure Linked list
 * @param <E> The type of parameter.
 **/
public class LinkedList<E> implements Iterable<E> {
    private Node<E> head,tail;
    private int size;

    /**
     * Linked List constructor with a list type parameter
     * @param doubles static array
     **/
    public LinkedList(E[] doubles){
        this.head=null;
        this.tail=null;
        this.size=0;
        for (E i:doubles) {
            this.add(i);
        }
    }
    /**
     * Linked List constructor without parameters
     **/
    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    /**
     * Linked List constructor without parameters
     **/
    public void add(E value){
        Node<E> newTail = new Node<E>(value);
        if (this.size == 0){
            this.head=newTail;
            this.tail=newTail;
        }
        else{
            tail.setNext(newTail);
            tail = newTail;
        }
        size++;
    }


    /**
     * Remove an element of the linked list
     **/
    public void remove() {
        if (this.size == 0) {
            throw new NoSuchElementException("La lista se encuentra vacía.");
        }
        else if (this.size == 1){
            this.head=null;
            this.tail=null;
            this.size=0;
        }
        else{
            head = head.getNext();
            size--;

        }
    }
    /**
     * get the head of the list
     * @return the head
     **/
    public Node<E> getHead() {
        return head;
    }

    /**
     * get the size of the list
     * @return the head
     **/
    public int getSize() {
        return size;
    }

    /**
     * Set the head of the list
     * @param head new head
     **/
    public void setHead(Node<E> head) {
        this.head = head;
    }
    /**
     * get the Tail of the list
     * @return the head
     **/
    public Node<E> getTail() {
        return tail;
    }
    /**
     * Set the head of the list
     * @param tail new Tail.
     **/
    public void setTail(Node<E> tail) {
        this.tail = tail;
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> c = head;
            @Override
            public boolean hasNext() {
                return c != null;
            }

            @Override
            public E next() {
                E value = c.getValue();
                c = c.getNext();
                return value;
            }
        };
    }
    public Node<E> get(int index){
        Node<E> aux = head;
        for(int i=0;i<index;i++){
            aux = aux.getNext();
        }
        return aux;
    }
    public void set(int index,E value){
        Node<E> aux = head;
        for(int i=0;i<index;i++){
            aux = aux.getNext();
        }
        aux.setValue(value);
    }

    public static void bubbleSort(LinkedList<Double> arr)
    {
        int n = arr.getSize();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j).getValue() > arr.get(j+1).getValue()) {
                    // swap arr[j+1] and arr[i]
                    double temp = arr.get(j).getValue();
                    arr.get(j).setValue(arr.get(j + 1).getValue());
                    arr.get(j+1).setValue(temp);
                }
        }
    }

}