package com.twu.biblioteca;

public class QuitCommand implements Command{
    private String name;
    public QuitCommand(String name) {
        this.name = name;
    }

    @Override
    public String execute() {
        return "Quit";
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
