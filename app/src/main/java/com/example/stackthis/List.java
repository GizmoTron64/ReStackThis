package com.example.stackthis;

import java.util.ArrayList;


public abstract class List<E> {
    /**
     * An ArrayList of fixed size
     */
    private ArrayList<E> list;
    private int capacity;

    /**
     * Constructor for List object
     */
    public List() {
        capacity = 15;
        list = new ArrayList<E>(capacity);
    }

    /**
     * Getter for list
     * @return list
     */
    public ArrayList<E> getList() {
        return list;
    }

    /**
     * Setter for list
     * @param list
     */
    public void setList(ArrayList<E> list) {
        this.list = list;
    }

    /**
     * Getter for list capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setters for list capacity
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Adds an object to the the end of the list
     * @param val object added to the list
     */
    public void add(E val) {
        if(list.size() < capacity) {
            list.add(val);
        }
    }

    /**
     * Removes an object from the list
     */
    public abstract void remove();

    /**
     * Removes all objects from the list
     */
    public void clearQueue() {
        list.clear();
    }

    /**
     * Returns the size of the list
     * @return size
     */
    public int size() {
        return list.size();
    }

}
