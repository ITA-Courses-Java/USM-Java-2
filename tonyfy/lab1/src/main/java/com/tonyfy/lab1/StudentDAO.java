package com.tonyfy.lab1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class StudentDAO {

    static DBConnectionManager db =
            new MySQLConnectionManager("localhost",
                                       "USM-Java-2",
                                       "root",
                                       "0000");

    public static List<Student> selectAll() {
        List<Student> students = new LinkedList<Student>();

        try {
            db.connect();

            Statement statement = db.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM `Student`");

            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"),
                                         resultSet.getString("firstName"),
                                         resultSet.getString("lastName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }

        return students;
    }

    public static void add(Student student) {
        try {
            db.connect();

            Statement statement = db.getConnection().createStatement();
            statement.execute(
                    "INSERT INTO `Student` (" +
                    "`firstName` , `lastName`" +
                    ")" +
                    "VALUES (" +
                    "'" + student.firstName + "', " +
                    "'" + student.lastName + "'" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    public static void delete(int id) {
        try {
            db.connect();

            Statement statement = db.getConnection().createStatement();
            statement.execute(
                    "DELETE FROM `Student`" +
                    "WHERE `id` = " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

}
