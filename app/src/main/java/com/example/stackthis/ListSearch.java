package com.example.stackthis;

import java.util.ArrayList;
import java.util.Random;

public class ListSearch<E> extends List<E> {

    private Random rand;

    public ListSearch() {
        super();
        rand = new Random();
    }


//    public int search(listData, value) {
//        index = 0;
//        while (index < len(listData) and listData[index] < value) {
//            index++;
//        }
//
//        if (index >= len(listData) or listData[index] != value) {
//            return -1;
//        }
//
//        return index;
//    }
//

    /**
     * This needs to fill in an ascending order
     * make a variable and add a small random number each time
     */
    public void fillList() {
        Integer num = rand.nextInt(11);
        for (int i = 0; i < size(); i++) {
            num += rand.nextInt(11);
            add((E) num);
        }
    }

    public void remove() {

    }


}
