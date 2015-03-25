package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private Library library;
    private final List<Command> commands = new ArrayList<Command>();

    public Biblioteca(Library library) {
        this.library = library;
    }
    public String getMessage() {
        return "Welcome to Biblioteca!";
    }

    public String listBooks() {
        String bookListing = "Title\t\tAuthor\t\tYear" + System.lineSeparator();
        if(library.isEmpty()) {
            return "Sorry, No Books found in Library!";
        }
        for (Book book : library.listBooks()) {
            bookListing += book.toString() + System.lineSeparator();
        }
        return bookListing;
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public String issueBook(String title, String author, int year) {
        return library.issue(title,author,year) != null ? "Thank you! Enjoy the book" : "That book is not available.";
    }

    public String handleOption(int option) {
        try{
            return commands.get(option-1).execute();
        }
        catch (IndexOutOfBoundsException e){
            return "Select Valid Option.";
        }

   }

    public void displayOptions() {
        int count = 0;
        for (Command command : commands) {
            System.out.print(++count + ". ");
            command.display();
        }
    }

    public String returnBook(Book book) {
        if(library.returnBook(book)){
            return "Thank you for Returning the Book!";
        }
        return "That is not a valid book to return.";
    }
}
