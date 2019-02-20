package com.example.stackthis;


import java.util.ArrayList;

public class Queue<E> {
    /**
     * A First-in, First-out Queue object
     */

    private ArrayList<E> queue;
    private int capacity;

    /**
     * Constructor for Queue object
     */
    public Queue() {
        capacity = 15;
        queue = new ArrayList<E>(capacity);
    }

    /**
     * Adds an object to the the end of the queue
     * @param val object added to the queue
     */
    public void add(E val) {
        if(queue.size() < capacity) {
            queue.add(val);
        }
    }

    /**
     * Removes the first object from the queue
     */
    public void remove() {
        if(!queue.isEmpty()) {
            queue.remove(0);
        }
    }

    /**
     * Removes all objects from the queue
     */
    public void clearQueue() {
        queue.clear();
    }

    /**
     * Returns the size of the queue
     * @return size
     */
    public int size() {
        return queue.size();
    }

    /**
     * Returns the object at the end of the queue
     * @return tail
     */
    public E tail() {
        return queue.get(size() -1);
    }

    public ArrayList<E> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<E> queue) {
        this.queue = queue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
