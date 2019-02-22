package com.example.stackthis;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue<E> extends ArrayList<E> {
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
    public void dequeue() {
        remove(0);
    }

    /**
     * Returns the object at the end of the list
     * @return tail
     */
    public String tail() {
        return Integer.toString(size());
    }

}
