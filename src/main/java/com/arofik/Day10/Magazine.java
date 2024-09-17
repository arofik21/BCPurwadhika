package com.arofik.Day10;

public class Magazine extends LibraryMaterial {
    private int issueNumber;

    public Magazine(String title, int issueNumber, int totalCopies) {
        super(title, totalCopies);
        this.issueNumber = issueNumber;
    }

    @Override
    public void showDetails() {
        System.out.println("Magazine: " + title + " | Issue: " + issueNumber + " | Available copies: " + availableCopies);
    }
}