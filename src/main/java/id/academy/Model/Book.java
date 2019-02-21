package id.academy.Model;

import id.academy.view.BookService;

public class Book {
    private  int id;
    private String name;
    private String author;

    public Book(int id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
