package com.twu.biblioteca;

public class ListBooksCommand implements Command {
    private String name;
    private Biblioteca biblioteca;

    public ListBooksCommand(String name, Biblioteca biblioteca) {
        this.name = name;
        this.biblioteca = biblioteca;
    }

    public String execute(){
        return biblioteca.listBooks();
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
