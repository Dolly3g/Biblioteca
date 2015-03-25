package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library{
    private final List<Book> availableBooks = new ArrayList<Book>();
    private final List<Book> issuedBooks = new ArrayList<Book>();

    public List<Book> listBooks() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.addAll(availableBooks);
        //Readable list
        return bookList;
    }

    public void add(Book book) {
        availableBooks.add(book);
    }
    public boolean isAvailable(Book book) {
        return availableBooks.contains(book);
    }

    @Override
    public String toString() {
        return "All Books:\n" + availableBooks;
    }

    public Book issue(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if(isAvailable(book)){
            int index = availableBooks.indexOf(book);
            issuedBooks.add(book);
            availableBooks.remove(index);
            return book;
        }
        return null;
    }

    boolean isEmpty() {
        return availableBooks.size() == 0;
    }

    public boolean returnBook(Book book) {
        if(issuedBooks.contains(book)){
            availableBooks.add(book);
            return true;
        }
        return false;
    }
}
