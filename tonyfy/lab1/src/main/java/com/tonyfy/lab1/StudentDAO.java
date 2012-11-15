package com.tonyfy.lab1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM `Student`");
            ResultSet resultSet = statement.executeQuery();

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

            PreparedStatement statement = db.getConnection().prepareStatement(
                    "INSERT INTO `Student` (" +
                    "`firstName` , `lastName`" +
                    ")" +
                    "VALUES (?, ?)");
            statement.setString(1, student.firstName);
            statement.setString(2, student.lastName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

    public static void delete(int id) {
        try {
            db.connect();

            PreparedStatement statement = db.getConnection().prepareStatement(
                "DELETE FROM `Student`" +
                "WHERE `id` = ?");
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
    }

}
