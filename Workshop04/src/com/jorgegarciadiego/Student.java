// Workshop 4
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/19/2020
// File: Student.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgegarciadiego;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdID;
    private String firstName;
    private String lastName;
    private final ArrayList<String> courses;

    public Student(){
            stdID = 0;
            firstName = "";
            lastName = "";
            courses = new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStdID(int stdID) throws Exception {
        if (stdID > 0)
            this.stdID = stdID;
        else
            throw new Exception("Invalid Student ID!");
    }

    public void setCourse(String courses) {
        this.courses.add(courses);
    }
    
    public void setCourses(ArrayList<String> courses){
        this.courses.addAll(courses);
    }

    public int getStdID() {
        return stdID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +"\n" +
                "  stdID=" + stdID + "\n" +
                "  firstName='" + firstName + "\n" +
                "  lastName='" + lastName + "\n" +
                "  courses=" + courses + "\n" +
                '}';
    }
}
