package com.arofik.Day1;

public class Book extends LibraryMaterial {
    private String author;

    public Book(String title, String author, int totalCopies) {
        super(title, totalCopies);
        this.author = author;
    }

    @Override
    public void showDetails() {
        System.out.println("Book: " + title + " by " + author + " | Available copies: " + availableCopies);
    }
}