package com.example.stackthis;

import java.util.ArrayList;
import java.util.Random;

public class ListSearch<String> extends ArrayList<String>{

    private Random rand;
    private int capacity;
    private Integer num;

    public ListSearch() {
        super();
        rand = new Random();
        capacity = 9;
    }

    /**
     * This needs to fill in an ascending order
     * make a variable and add a small random number each time
     */
    public void fillList() {
        for (int i = 0; i < capacity; i++) {
            num += rand.nextInt(11);
            add((String) num);
        }
    }


}
