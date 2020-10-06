// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: Triangle.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.shapes;

public class Triangle extends Polygon {

    public Triangle(String shape, double [] sides) throws PolygonException {
        super(shape, sides);
    }

    @Override
    public double perimeter() {
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public String toString() {
        return String.format("%s {s1=%.2g, s2=%.2g, s3=%.2g} perimeter = %7g \n", this.getClass().getSimpleName(),
                getSides()[0], getSides()[1], getSides()[2], perimeter());
    }

    @Override
    public void validatePolygon() {
        if (!validateSides())
            System.out.println("Invalid side(s)!");
    }
}
