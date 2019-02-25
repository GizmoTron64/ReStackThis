package com.example.stackthis;

import java.util.ArrayList;
import java.util.Random;

public class ListSearch extends ArrayList {
    /**
     * An ArrayList of fixed capacity filled with random integers in ascending order
     */
    private Random rand;
    private int capacity;
    private int num;

    /**
     * Default constructor for ListSearch
     */
    public ListSearch() {
        super();
        rand = new Random();
        capacity = 10;
        fillList();
    }

    /**
     * Getter for list capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter for list capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter for the next random integer
     * @return next random integer
     */
    public int getNum() {
        return num;
    }

    /**
     * Setter for the next random integer
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * Fills the list with random integers in ascending order
     */
    public void fillList() {
        num = 0;
        for (int i = 0; i < capacity; i++) {
            num += rand.nextInt(11);
            add(num);
        }
    }
}
