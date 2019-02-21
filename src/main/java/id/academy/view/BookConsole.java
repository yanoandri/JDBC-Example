package id.academy.view;

import id.academy.Model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookConsole implements BookViewHandling {
    private Scanner scanner = new Scanner(System.in);
    private BookService service = new BookServiceImpl(this);

    public void start(){
        System.out.println("===== Activity");
        System.out.println("1. Add");
        System.out.println("2. Get One");
        System.out.println("3. Get All");
        System.out.println("4. Update");
        System.out.println("5. Remove");
        System.out.print("Choose 1, 2, 3 or 4 : ");
        int option = this.scanner.nextInt();
        switch (option){
            case 1:
                add();
                break;
            case 2:
                getOne();
                break;
            case 3:
                getAll();
                break;
            case 4:
                update();
                break;
            case 5:
                remove();
                break;
                default:
                    break;
        }
    }

    public void add(){
        System.out.println("Book name : ");
        String bookName = scanner.next();

        System.out.println("Book author : ");
        String bookAuthor = scanner.next();

        Book book = new Book(bookName, bookAuthor);
        service.add(book);
    }

    public void update(){
        getAll();
        System.out.println("Which id you want to see? : ");
        int id = scanner.nextInt();
        Book book = service.getOne(id);
        System.out.println(book.getId() + ". "+ book.getName() + ", " + book.getAuthor());

        System.out.println("======Updating data=======");

        System.out.println("Name : ");
        String name = scanner.next();
        book.setName(name);

        System.out.println("Author : ");
        String author = scanner.next();
        book.setAuthor(author);

        service.update(book);
    }

    public void remove(){
        getAll();
        System.out.println("Which id you want to see? : ");
        int id = scanner.nextInt();
        Book book = service.getOne(id);
        System.out.println(book.getId() + ". "+ book.getName() + ", " + book.getAuthor());

        System.out.println("======Deleting data=======");
        service.delete(book);
    }

    public void getAll(){
        System.out.println("Getting all the books : ");
        ArrayList<Book> list = service.getAll();
        if (list.size() > 0){
            for (Book book: list) {
                System.out.println(book.getId() + ". "+ book.getName() + ", " + book.getAuthor());
            }
        }
    }

    public void getOne(){
        getAll();
        System.out.println("Which id you want to see? : ");
        int id = scanner.nextInt();
        Book book = service.getOne(id);
        System.out.println(book.getId() + ". "+ book.getName() + ", " + book.getAuthor());
    }

    public void onSuccess() {
        System.out.println("Operation success");
    }

    public void onFailed() {
        System.out.println("Operation failed");
    }

    public void onError(String message) {
        System.out.println("ERROR : " + message);
    }
}
