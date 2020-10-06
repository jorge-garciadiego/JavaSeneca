// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: Rectangle.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.shapes;

//Rectangle subclass extends Polygon and inherits to Square
public class Rectangle extends Polygon {

    public Rectangle(String shape, double [] sides) throws PolygonException {
        super(shape, sides);
    }

    @Override
    public double perimeter() {
        return 2*getSides()[0] + 2*getSides()[1];
    }

    @Override
    public String toString() {
        return String.format("%s {w = %.2g, h = %.2g} perimeter = %7g \n", this.getClass().getSimpleName(),
                getSides()[0], getSides()[1], perimeter());
    }

    @Override
    public void validatePolygon() {
        if (!validateSides())
            System.out.println("Invalid sides(s)!");
    }
}
