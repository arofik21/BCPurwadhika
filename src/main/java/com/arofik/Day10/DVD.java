package com.arofik.Day10;

public class DVD extends LibraryMaterial {
    private int duration;  // duration in minutes

    public DVD(String title, int duration, int totalCopies) {
        super(title, totalCopies);
        this.duration = duration;
    }

    @Override
    public void showDetails() {
        System.out.println("DVD: " + title + " | Duration: " + duration + " mins | Available copies: " + availableCopies);
    }
}