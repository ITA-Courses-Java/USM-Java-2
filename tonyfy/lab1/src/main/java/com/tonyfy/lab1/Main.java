package com.tonyfy.lab1;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (Student student : StudentDAO.getStudentsList()) {
            System.out.println(student);
        }
    }

}
