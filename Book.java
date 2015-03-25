package com.twu.biblioteca;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String Author, int year) {
        this.title = title;
        author = Author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (year != book.year) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return title + "\t\t" + author + "\t\t" + year;
    }
}
