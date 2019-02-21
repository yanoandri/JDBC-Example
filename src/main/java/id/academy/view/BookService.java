package id.academy.view;

import id.academy.Model.Book;

public interface BookService {

    void add(Book book);

    void update(Book book);

    void delete(Book book);

    void getAll();

    void getBookByTitle(String title);
}
