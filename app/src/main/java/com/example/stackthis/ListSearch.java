package com.example.stackthis;

import java.util.ArrayList;
import java.util.Random;

public class ListSearch extends ArrayList {

    private Random rand;
    private int size;
    private int num;

    public ListSearch() {
        super();
        rand = new Random();
        size = 9;
    }

    /**
     * This needs to fill in an ascending order
     * make a variable and add a small random number each time
     */
    public void fillList() {
        for (int i = 0; i < size; i++) {
            num += rand.nextInt(11);
            add(num);
        }
    }


}
