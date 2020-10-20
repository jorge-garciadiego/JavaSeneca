// Workshop 4
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/19/2020
// File: ReadStudent.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgegarciadiego;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadStudent {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream("students.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();

            fis.close();
        } catch (Throwable e){
            System.err.println(e);
        }
        for (Student student: students) {
            System.out.println("Deserialization->readObject class: " + student.getClass().getSimpleName());
            System.out.println("Deserialization->readObject stdID: " + student.getStdID());
            System.out.println("Deserialization->readObject First Name: " + student.getFirstName());
            System.out.println("Deserialization->readObject Last Name: " + student.getLastName());
            System.out.println("Deserialization->readObject Courses: " + student.getCourses());
            System.out.println("Deserialization->readObject toString Method->\n" + student.toString());
        }

    }
}
