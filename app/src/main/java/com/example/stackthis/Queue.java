package com.example.stackthis;


import java.util.ArrayList;

public class Queue<E> extends List<E> {
    /**
     * A First-in, First-out Queue of fixed size
     */

    /**
     * Constructor for Queue object
     */
    public Queue() {
        super();
    }

    /**
     * Removes the first object from the list
     */
    public void remove() {
        if(!getList().isEmpty()) {
            getList().remove(0);
        }
    }

    /**
     * Returns the object at the end of the list
     * @return tail
     */
    public E tail() {
        return getList().get(size() -1);
    }

}
