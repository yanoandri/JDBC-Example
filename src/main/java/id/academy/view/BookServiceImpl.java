package id.academy.view;

import id.academy.Model.Book;
import id.academy.config.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;

public class BookServiceImpl implements BookService {

    private Connection connection = JDBCConnector.getConnection();
    private BookViewHandling view;

    public BookServiceImpl(BookViewHandling view){
        this.view = view;
    }


    public void add(Book book) {
        String query = "insert into book (nama, author, created_at, updated_at) "
                + "values (?, ?, ?, ?)";

        try {
            PreparedStatement prepStatement = this.connection.prepareStatement(query);
            prepStatement.setString(1, book.getName());
            prepStatement.setString(2, book.getAuthor());
            prepStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            prepStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            boolean isFailed = prepStatement.execute();
            if (!isFailed){
                view.onSuccess();
            }else {
                view.onFailed();
            }
        } catch (SQLException e) {
            view.onError(e.getMessage());
        }
    }

    public void update(Book book) {
        String query = "update book set nama = ?, author = ? where id = ?";

        try {
            PreparedStatement prepStatement = this.connection.prepareStatement(query);
            prepStatement.setString(1, book.getName());
            prepStatement.setString(2, book.getAuthor());
            prepStatement.setInt(3, book.getId());
            boolean isFailed = prepStatement.execute();
            if (!isFailed){
                view.onSuccess();
            }else {
                view.onFailed();
            }
        } catch (SQLException e) {
            view.onError(e.getMessage());
        }
    }

    public void delete(Book book) {
        String query = "delete from book where id = ?";

        try {
            PreparedStatement prepStatement = this.connection.prepareStatement(query);
            prepStatement.setInt(1, book.getId());
            boolean isFailed = prepStatement.execute();
            if (!isFailed){
                view.onSuccess();
            }else {
                view.onFailed();
            }
        } catch (SQLException e) {
            view.onError(e.getMessage());
        }
    }

    public ArrayList<Book> getAll() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        String query = "select * from book";

        try {

            PreparedStatement statement = this.connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Book book = new Book(rs.getInt("id"),rs.getString("nama"), rs.getString("author"));
                bookList.add(book);
            }

        } catch (SQLException e) {
            view.onError(e.getMessage());
        }
        return bookList;
    }

    public Book getOne(int id) {
        Book book = null;
        String query = "select * from book where id = ?";

        try {

            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                book = new Book(rs.getInt("id"),rs.getString("nama"), rs.getString("author"));
            }

        } catch (SQLException e) {
            view.onError(e.getMessage());
        }
        return book;
    }
}
