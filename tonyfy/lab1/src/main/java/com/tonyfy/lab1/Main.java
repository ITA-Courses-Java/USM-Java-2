package com.tonyfy.lab1;

import java.sql.SQLException;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            for (Student student : StudentDAO.selectAll()) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
