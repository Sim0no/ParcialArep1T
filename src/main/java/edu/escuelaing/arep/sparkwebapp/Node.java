package edu.escuelaing.arep.sparkwebapp;

/**
 * Node Class representing element for the linked list
 *
 * @param <E> the type parameter
 */

public class Node<E> {

    private E value;
    private Node<E> next;
    /**
     * Node constructor, take the value of our Node as argument
     *
     * @param value the data
     */
    public Node(E value) {
        this.value = value;
        this.next=null;
    }
    /**
     * Gets value of our Node.
     *
     * @return the value.
     */
    public E getValue() {
        return value;
    }

    /**
     * Set value of our Node.
     *
     * @param value New value
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * Gets the next Node.
     *
     * @return the next Node.
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * Set the next Node.
     * @param next Next node.
     */

    public void setNext(Node<E> next) {
        this.next = next;
    }
}