package id.academy.view;

import id.academy.Model.Book;
import id.academy.Model.Books;

import java.util.ArrayList;

public interface BookViewHandling {

    void onSuccess();

    void onFailed();

    void onError(String message);

    void onSelectOne(Book book);

    void onSelectAll(Books books);
}
