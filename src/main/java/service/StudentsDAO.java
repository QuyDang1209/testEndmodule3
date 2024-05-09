package service;

import Model.Book;
import Model.IStudents;
import Model.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO implements IStudents {
    private String jdbcURL = "jdbc:mysql://localhost:3306/libary?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "quydang123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public Students findStuByID(int id) {
        Students students = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from students where studentID=?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String classes = rs.getString("class");
                students = new Students(id, name,classes);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<Students> showstudent() {
        List<Students> students = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students;");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("studentID");
                String name = rs.getString("name");
                String classes = rs.getString("class");
                Students students1 = new Students(id,name,classes);
                students.add(students1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
