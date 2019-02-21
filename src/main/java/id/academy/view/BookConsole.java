package id.academy.view;

import id.academy.Model.Book;
import id.academy.Model.Books;

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
        try {
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
                    //update();
                    break;
                case 5:
                    //remove();
                    break;
                default:
                    break;
            }
        }catch (Exception ex){
            System.out.println("INVALID OPERATION");
            start();
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

    public void getAll(){
        System.out.println("Getting all the books : ");
        service.getAll();
    }

    public void getOne(){
        System.out.println("Which title you want to see? : ");
        String title = scanner.next();
        service.getBookByTitle(title);
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

    public void onSelectOne(Book book) {
        if (book != null){
            System.out.println("ID : " + book.getId());
            System.out.println("NAMA : " + book.getName());
            System.out.println("AUTHOR : " + book.getAuthor());
            System.out.println("CREATED DATE : " + book.getCreatedDate());
            System.out.println("UPDATED DATE : " + book.getUpdatedDate());
        }else{
            System.out.println("Book not exists....");
        }
    }

    public void onSelectAll(Books books) {
        for (Book book : books.getList()) {
            onSelectOne(book);
            System.out.println();
        }
    }
}
