package service;

import Model.Book;
import Model.IBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBook {
    private String jdbcURL = "jdbc:mysql://localhost:3306/libary?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "quydang123456";

    public BookDAO() {
    }

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

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Book> showAllBook() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book;");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bookID");
                String name = rs.getString("bookName");
                String author = rs.getString("author");
                String decription = rs.getString("decription");
                int quantity = rs.getInt("quantity");
                Book book = new Book(id, name, author, decription, quantity);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
    public Book findBookByID(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from book where bookID=?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("bookName");
                String author = rs.getString("author");
                String decription = rs.getString("decription");
                int quantity = rs.getInt("quantity");
                book = new Book(id, name, author, decription, quantity);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}

