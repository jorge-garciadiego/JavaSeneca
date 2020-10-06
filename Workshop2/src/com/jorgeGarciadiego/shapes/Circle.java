// Workshop 2
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/05/2020
// File: Circle.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgeGarciadiego.shapes;

import java.text.DecimalFormat;

//Circle subclass implements Shape interface
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) throws CircleException{
        if (radius > 0)
            this.radius = radius;
        else {
            throw new CircleException("Invalid radius!");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0)
            this.radius = radius;
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI) * getRadius();
    }

    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat("0.0##");
        return String.format("%s {r = %s} perimeter = %7g \n", this.getClass().getSimpleName(),
                df2.format(getRadius()), perimeter());
    }
}
