package com.arofik.Day6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArraySort {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the array elements from the user
        System.out.print("Enter the elements of the array separated by spaces: ");
        String input = scanner.nextLine();
        String[] elements = input.split("\\s+");

        // Convert the string array to an Integer array
        Integer[] arr = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            try {
                arr[i] = Integer.parseInt(elements[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + elements[i]);
                return; // Exit if there's an invalid number
            }
        }

        // Get the sorting direction from the user
        System.out.print("Enter the sorting direction (asc/desc): ");
        String direction = scanner.nextLine().trim().toLowerCase();

        // Sort the array based on the direction
        if (direction.equals("asc")) {
            Arrays.sort(arr); // Sort in ascending order
        } else if (direction.equals("desc")) {
            Arrays.sort(arr, Collections.reverseOrder()); // Sort in descending order
        } else {
            System.out.println("Invalid direction. Please enter 'asc' or 'desc'.");
            return; // Exit if the direction is invalid
        }

        // Print the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
