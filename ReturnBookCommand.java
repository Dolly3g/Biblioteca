package com.twu.biblioteca;

public class ReturnBookCommand implements Command {
    private String name;
    private Biblioteca biblioteca;
    private Book book;

    public ReturnBookCommand(String name, Biblioteca biblioteca, Book book) {
        this.name = name;
        this.biblioteca = biblioteca;
        this.book = book;
    }

    @Override
    public String execute() {
        return biblioteca.returnBook(book);
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
