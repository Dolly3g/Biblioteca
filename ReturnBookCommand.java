package com.twu.biblioteca;

import java.util.Map;
import java.util.Scanner;

public class ReturnBookCommand implements Command {
    private String name;
    private Biblioteca biblioteca;
    private Map<String, String> data;

    public ReturnBookCommand(String name, Biblioteca biblioteca, Map<String, String> data) {
        this.name = name;
        this.biblioteca = biblioteca;
        this.data = data;
    }

    @Override
    public String execute() {
        if(data.size() == 0){
            Scanner scanner = new Scanner(System.in);
            data.put("title",scanner.nextLine());
            data.put("author",scanner.nextLine());
            data.put("year",scanner.next());
        }
        int year = Integer.parseInt(data.get("year"));
        Book book = new Book(data.get("title"), data.get("author"), year);
        data.clear();
        return biblioteca.returnBook(book);
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
