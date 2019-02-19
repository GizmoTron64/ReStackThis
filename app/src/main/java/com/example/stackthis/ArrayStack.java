package com.example.stackthis;

public class ArrayStack<E>
{
    int top;
    E[] S;
    /**
     * Constructor for objects of class com.example.stackthis.ArrayStack
     */
    public ArrayStack(int capacity)
    {
        top = -1;
        S = (E[]) new Object[capacity];
        // Casting is used in the above as generic arrays cannot be created using new E[]
    }

    public void push(E element) {
        if(S.length > size()) {
            S[size()] = element;
            top++;
        }
        else {
            E stored = element;
            Object[] temporyArray = new Object[size()*2];
            for(int index=0; index < size(); index++) {
                temporyArray[index] = S[index];}
            S = (E[]) temporyArray;
            push(stored);
        }
    }


    public E pop() {
        E a = null;
        if(size() != 0) {
            a = S[size()-1];
            S[size()-1] = null;
            top-= 1;
        }
        else {
            System.out.println("Stack is empty");
        }
        return a;
    }

    public E top() {
        if(top >= 0 && top <= S.length) {
            return S[top];
        }
        else if(top < 0) {
            top = 0;
            return S[top];
        }
        else {
            top = S.length;
            return S[top];
        }

    }

    public int size() {
        int count = 0;
        boolean nullCheck = false;
        while(count < S.length && nullCheck == false) {
            if(S[count] == null) {
                nullCheck = true;
            }
            else {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {

        int a = size();
        if(a != 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void printMe() {
        for(int k =0;k < S.length;k++){
            System.out.println(S[k]);
        }
    }
}
