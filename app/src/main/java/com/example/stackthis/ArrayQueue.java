package com.example.stackthis;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        head = 0;
        tail = 0;
        size = 0;
        queue = new int[capacity];
    }

    public ArrayQueue() {
         this(10);
    }


    public void enqueue(int val) {

    }

    public void dequeue() {

    }

    public void clearQueue() {
        
    }

}
