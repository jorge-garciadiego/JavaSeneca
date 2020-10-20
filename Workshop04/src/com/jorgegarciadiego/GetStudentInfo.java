// Workshop 4
// Name: Jorge Garciadiego
// Seneca Student ID: 142099183
// Seneca email: jgarciadiego-molina@myseneca.ca
// Submitted by Jorge on Oct/19/2020
// File: GetStudentInfo.java
/*"I have done all the coding by myself to complete this workshop."*/

package com.jorgegarciadiego;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GetStudentInfo {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean addStudent = true;
        boolean valid = false;
        String strInput;
        ArrayList<Student> students = new ArrayList<>();
        try{
            do {
                Student student = new Student();

                while (!valid){
                    System.out.print("Enter Student ID: ");
                    strInput = scan.nextLine();
                    try{
                        student.setStdID(Integer.parseInt(strInput));
                        valid = true;
                    } catch (NumberFormatException e){
                        System.out.println("Error - You need to enter an integer value.");
                    }
                }
                valid = false;
                System.out.print("Enter student's first name: ");
                student.setFirstName(scan.next());
                System.out.print("Enter student's last name: ");
                student.setLastName(scan.next());
                
                boolean add = true;

                do {
                    System.out.println("Type the course [0 to exit]: ");
                    String course = scan.next();

                    if (course.equals("0"))
                        add = false;
                    else
                        student.setCourse(course);
                } while (add);

                students.add(student);
                System.out.print("Do you want to enter another student? (y or n): ");
                String choice = scan.next();

                while(!(choice.equalsIgnoreCase("y")) && !(choice.equalsIgnoreCase("n"))){
                    System.out.print("Invalid answer try again: ");
                    choice = scan.next();
                }

                if (choice.equalsIgnoreCase("n"))
                    addStudent = false;

            } while (addStudent);

            writeObjs(students);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    private static void writeObjs(ArrayList<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream("students.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            /*
            for (Student student: students) {
                oos.writeObject(student);
            }
            */
            oos.writeObject(students);

            oos.flush();
            fos.close();

        }catch (Throwable e){
            System.err.println(e);
        }
    }
}
