// Workshop 1
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Sep/28/2020
// File: Stack.java

/*"I have done all the coding by myself to complete this workshop."*/

package com.helloImJorge;

// import java.util.Arrays;

public class Stack {
    private int capacity;
    private char [] stack;
    private int topElement;

    public Stack(int capacity){
        //Stack constructor with an int arg that instantiate a char array of capacity size that represents the stack
        stack = new char[capacity];
        topElement = 0;
        this.capacity =  capacity;
    }

    public void push(char element){
        //insert a new character at the nearest available index from the beginning of the stack
        //if the size is equal to the capacity of the stack calls the expand method
        //to resize the stack if not it will insert the element after the last position.
        if (getSize() == capacity)
            expand();

        stack[topElement] = element;
        topElement++;
    }

    public char pop(){
        //Drops the last stack element of the stack, in case the stack is empty it'll prompt a message
        //after dropping the element it calls the shrink method that re-size the stack
        char element = ' ';
        if (isEmpty()){
            System.out.println("Stack is empty!");
        } else {
            topElement--;
            element = stack[topElement];
            stack[topElement] = ' ';
            shrink();
        }
        return element;
    }

    public int getSize(){
        return topElement;
    }

    public boolean isEmpty(){
        return topElement <= 0;
    }

    public void show(){
        //Displays all the stack elements
        for (char character : stack){
            System.out.printf("%s", character + " ");
        }
    }

    public char elementAt(int position){
        //Returns the element stored at the specified position which is received as an argument
        char element;
        if (capacity > 0)
            element = stack[position];
        else
            element = ' ';

        return element;
    }

    private void expand(){
        //expands the stack's size by one char
        if (capacity > 0){
            char [] newStack = new char[capacity + 1];

            for (int i = 0; i < capacity; i++) {
                newStack[i] = stack[i];
            }
            capacity += 1;
            // System.arraycopy(stack, 0, newStack, 0, capacity);
            // since I didn't know if arraycopy was allowed I preferred to code a manual copy
            stack = newStack;
        }
    }

    private void shrink(){
        //Reduce the stack's size by one char
        if(getSize() <= capacity)
            capacity -= 1;
        char [] newStack = new char[capacity];
        // since I didn't know if arraycopy was allowed I preferred to code a manual copy
        for (int i = 0; i < capacity; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

}
