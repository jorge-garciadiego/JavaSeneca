// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: main.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.main;

import com.jorgeGarciadiego.shapes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args){
        String [] shapesArray = new String[0];
        String [] invalidShapesArray = new String[0];
        String [] validShapes = {"Rectangle", "Square", "Triangle", "Circle", "Parallelogram"};
        String fileName = "shapes.txt";
        String s;
        Shape [] arrayShapes = new Shape[0];

        System.out.println("------->JAC 444 Assignment 1 <-------");
        System.out.println("------->Task 1 ... <-------");

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while ((s = br.readLine()) != null){
                String[] tokens = s.split(",");
                boolean tokenChecker = false;
                for (String shape: validShapes) {
                    if (shape.equals(tokens[0])) {
                        tokenChecker = true;
                        break;
                    }
                }
                if (tokenChecker){
                   shapesArray =  expand(shapesArray, s);
                } else {
                    invalidShapesArray = expand(invalidShapesArray, s);
                }

            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        for (String shape: shapesArray) {
            Shape tempShape = null;
            String[] tokens = shape.split(",");
            double [] sides;
            switch (tokens[0]){
                case "Circle":
                    if (tokens.length == 2)
                        try{
                            tempShape = new Circle(Double.parseDouble(tokens[1]));
                        } catch (CircleException message){
                            System.out.println(message.getMessage());
                        }
                    break;
                case "Square":
                    if (tokens.length == 2) {
                        sides = new double[]{Double.parseDouble(tokens[1])};
                        try{
                            tempShape = new Square(tokens[0], sides);
                        } catch (PolygonException message){
                            System.out.println(message.getMessage());
                        }
                    }
                    break;
                case "Rectangle":
                    if (tokens.length == 3){
                        sides = new double[]{Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])};
                        try{
                            tempShape = new Rectangle(tokens[0], sides);
                        } catch (PolygonException message){
                            System.out.println(message.getMessage());
                        }
                    }
                    break;
                case "Triangle":
                    if (tokens.length == 4){
                        sides = new double[]{Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])};
                        try {
                            tempShape = new Triangle(tokens[0], sides);
                        } catch (PolygonException message){
                            System.out.println(message.getMessage());
                        }
                    }
                    break;
                case "Parallelogram":
                    if (tokens.length == 3){
                        sides = new double[]{Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])};
                        try{
                            tempShape = new Parallelogram(tokens[0], sides);
                        } catch (PolygonException message){
                            System.out.println(message.getMessage());
                        }
                    }
                    break;
            }
           arrayShapes =  expand(arrayShapes, tempShape);
        }

        System.out.println("\n" + arrayShapes.length + " shapes were created:");
        for (Shape shape: arrayShapes) {
            System.out.println(shape.toString());
        }

    }

    //This methods are for storing new elements into an array of type, since they functionality is the same
    //The goal is to convert them into a template
    private static String [] expand(String [] arrayToExpand, String line){
        if (line != null){
            String [] newArray;
            if (arrayToExpand == null) {
                newArray = new String[1];
            } else {
                newArray = new String[arrayToExpand.length+1];
                System.arraycopy(arrayToExpand, 0, newArray, 0, arrayToExpand.length);
            }
            newArray[newArray.length - 1] = line;
            arrayToExpand = newArray;
        }
        return arrayToExpand;
    }

    private static Shape [] expand(Shape [] arrayToExpand, Shape shapeAdd){
        if (shapeAdd != null){
            Shape [] newArray;
            if (arrayToExpand == null) {
                newArray = new Shape [1];
            } else {
                newArray = new Shape[arrayToExpand.length+1];
                System.arraycopy(arrayToExpand, 0, newArray, 0, arrayToExpand.length);
            }
            newArray[newArray.length - 1] = shapeAdd;
            arrayToExpand = newArray;
        }
        return arrayToExpand;
    }

}
