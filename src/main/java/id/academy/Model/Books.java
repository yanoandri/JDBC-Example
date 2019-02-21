package id.academy.Model;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> list;

    public Books(){
        this.list = new ArrayList<Book>();
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void setList(ArrayList<Book> list) {
        this.list = list;
    }
}
