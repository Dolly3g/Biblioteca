package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppHandler {
    private Biblioteca biblioteca;
    private final Map<String, String> data = new HashMap<String, String>();;

    public AppHandler() {
        Library library = setupLibrary();
        biblioteca = new Biblioteca(library);
        setupCommands();
    }

    private void setupCommands() {
        biblioteca.addCommand(new ListBooksCommand("List Books",biblioteca));
        biblioteca.addCommand(new IssueBookCommand("Issue Book",biblioteca, data));
        biblioteca.addCommand(new QuitCommand("Quit"));
    }

    public Library setupLibrary(){
        Book b1 = new Book("Wings of Fire","A. P. J. Abdul Kalam",2010);
        Book b2 = new Book("Ramayana","Valmiki",1887);
        Book b3 = new Book("3 Mistakes of my life","Chetan Bhagat",2012);
        Book b4 = new Book("Revolution 2020","Chetan Bhagat",2010);
        Library library = new Library();
        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        return library;
    }

     int scanOption() {
        int option;
        try {
            option = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            option = -1;
        }
        return option;
    }

    public void run() {
        System.out.println(biblioteca.getMessage());
        while(true){
            biblioteca.displayOptions();
            System.out.println("Enter Option:");
            int option = scanOption();
            String result = biblioteca.handleOption(option);
            dealWithResult(result);
        }
    }

    private void dealWithResult(String result) {
        if(result.equals("Quit"))
            System.exit(0);
        System.out.println(result);
    }
}