package com.twu.biblioteca;

import java.util.Map;
import java.util.Scanner;

public class IssueBookCommand implements Command {
    private String name;
    private Biblioteca biblioteca;
    private Map<String, String> data;

    public IssueBookCommand(String name, Biblioteca biblioteca,Map<String,String> data) {
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
        String result = biblioteca.issueBook(data.get("title"), data.get("author"), Integer.parseInt(data.get("year")));
        data.clear();
        return result;
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
