// Workshop 1
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Sep/28/2020
// File: Palindrome.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.helloImJorge;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome(Stack stack){
        /*
            This method evaluates if the stack is a palindrome splitting the stack in two halves as mirrors
            i index goes from 0 to the middle size() - 1 / 2 and j from size() - 1 to the middle evaluates
            equality between both indexes and returns false in case of inequality.
         */
        boolean checker = true;
        if(!stack.isEmpty() && stack.getSize() > 1){
                for (int i = 0; i < ((stack.getSize() - 1) / 2 ); i++) {
                    for (int j = (((stack.getSize() * 2) - 1) / 2); j > 0 ; j--) {
                         if(stack.elementAt(i) != stack.elementAt(j))
                            return false;
                        i++;
                    }
                }
            }
         else {
            return false;
         }
        return true;
    }

    public static void validatePalindrome(Stack stack){
        // calls isPalindrome method and depending on the result prompts the user with a message
        if (isPalindrome(stack)){
            System.out.println(" -> is a palindrome!");
        } else {
            System.out.println(" -> is not a palindrome!");
        }
    }

    public static void print(Stack stack){
        //This method displays a grid with two rows one as a header with a cell for each position of the stack
        //the second row holds the representation of a cell for each character stored in the stack
        System.out.print("Position  -> | 1 | ");
        for (int i = 1; i < stack.getSize(); i++) {
            System.out.printf("%d | ", i + 1);
        }
        System.out.printf("%n");

        System.out.printf("Character -> | %s | ", stack.elementAt(0));
        for (int i = 1; i < stack.getSize(); i++) {
            System.out.printf("%s | ", stack.elementAt(i));
        }
    }

    public static void ensemblePalindrome(Stack stack, String data){
        //This function stores the elements of the string into the Stack object passing a character
        //of index i of the data String to the push() method of the Stack obj.
        if(data.length() > 0){
            for (int i = 0; i < data.length(); i++) {
                stack.push(data.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        //instantiation of the Stack object
        Stack stack = new Stack(args[0].length());

        //Pushing the elements from the String[] to the stack
        ensemblePalindrome(stack, args[0]);

        //The word is printed
        System.out.print("The word from the args [ ");
        stack.show();
        System.out.println("] has " + stack.getSize() + " elements\n");

        //Print a grid with the positions and the characters composing the word
        print(stack);
        //Validate if the stack is a Palindrome
        validatePalindrome(stack);

        //Input a character to be pushed to the stack
        System.out.print("Type a character to be pushed ->  ");
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);
        stack.push(c);

        System.out.println("Now the stack has " + stack.getSize() + " elements\n");
        //Print the grid again
        print(stack);
        //New validation with the new character
        validatePalindrome(stack);

        //Testing pop() method
        System.out.printf("Testing pop() method %s has been dropped \n", stack.pop());
        System.out.println("Now the stack has " + stack.getSize() + " elements\n");
        //Print the grid again
        print(stack);
        //New validation without a character
        validatePalindrome(stack);

        //Creating a new palindrome from input
        System.out.print("Enter a new word -> ");
        Scanner  input = new Scanner(System.in); //instantiates a Scanner object
        String stringInput = input.next(); //Stores the input into the String

        Stack palindrome2 = new Stack(stringInput.length()); //Creates a new Stack object
        ensemblePalindrome(palindrome2, stringInput); //Store the string inputted characters into the stack

        palindrome2.show();
        System.out.println("has " + palindrome2.getSize() + " elements\n");
        print(palindrome2);
        //New validation without a character
        validatePalindrome(palindrome2);
    }
}
