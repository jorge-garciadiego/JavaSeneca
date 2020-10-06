// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: Square.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.shapes;

//Square subclass inherits from Rectangle
public class Square extends Rectangle{
    public Square(String shape, double [] sides) throws PolygonException {
        super(shape, sides);
    }

    @Override
    public String toString() {
        return String.format("%s {s=%.1e} perimeter = %7g \n", this.getClass().getSimpleName(), getSides()[0], perimeter());
    }

    @Override
    public double perimeter() {
        return getSides()[0] * 4;
    }

    @Override
    public void validatePolygon() {
        if (!validateSides())
            System.out.println("Invalid size!");
    }
}
