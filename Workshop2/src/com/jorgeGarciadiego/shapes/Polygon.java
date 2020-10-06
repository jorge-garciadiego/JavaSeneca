// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: Polygon.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.shapes;

import java.text.DecimalFormat;

//Polygon is an abstract class that represents any polygon shape with a consisting of straight,
//non-intersecting line segments or "sides"
public abstract class Polygon implements Shape {
    String shapeType;
    double [] sides;

    //The constructor of this superclass evaluates the type of polygon in relation with the sides
    //This constructor throws exception depending on the logic of the shape
    //no shape can have a negative side
    //Triangle has to validate the inequality theorem
    public Polygon(String shape, double [] sides) throws PolygonException {
        int sidesNumber = sides.length;
        int sideChecker = 1;

        if (shape != null){
            this.shapeType = shape;

            if (sides.length == 2 && (shape.equals("Rectangle") || shape.equals("Parallelogram"))) {
                for (double side : sides) {
                    if (side < 0) {
                        sideChecker = 2;
                        break;
                    }
                }
            }
            if (sides.length == 3 && shape.equals("Triangle")) {
                if (((sides[0] + sides[1]) < sides[2]) || ((sides[1] + sides[2]) < sides[0]) ||
                        ((sides[2] + sides[0]) < sides[1])) {
                    sideChecker = 2;
                }
            }
            if (sides.length == 1 && shape.equals("Square")) {
                if (sides[0] < 0)
                    sideChecker = 3;
            }
            if (sideChecker == 1) {
                this.sides = new double[sidesNumber];
                this.sides = sides;
            } else if (sideChecker == 2) {
                throw new PolygonException("Invalid side(s)!");
            } else if (sideChecker == 3){
                throw new PolygonException("Invalid side!");
            }
        }
    }

    public double[] getSides() {
        return sides;
    }

    public boolean validateSides(){
        for (double side : sides) {
            if (side < 0) {
                return false;
            }
        }
        return true;
    }

    public abstract void validatePolygon();

}
