package id.academy.view;

import id.academy.Model.Book;

import java.util.ArrayList;

public interface BookService {

    void add(Book book);

    void update(Book book);

    void delete(Book book);

    ArrayList<Book> getAll();

    Book getOne(int id);
}
