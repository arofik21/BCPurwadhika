package com.arofik.Day10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some materials to the library
        library.addMaterial(new Book("The Great Gatsby", "F. Scott Fitzgerald", 3));
        library.addMaterial(new Magazine("National Geographic", 202, 5));
        library.addMaterial(new DVD("Inception", 148, 2));

        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. View all materials");
            System.out.println("2. Borrow a material");
            System.out.println("3. Return a material");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    library.showAllMaterials();
                    break;
                case 2:
                    System.out.print("Enter the title of the material to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowMaterial(borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the material to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnMaterial(returnTitle);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}