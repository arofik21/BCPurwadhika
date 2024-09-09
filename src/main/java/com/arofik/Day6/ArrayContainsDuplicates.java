package com.arofik.Day6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayContainsDuplicates {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the array elements from the user
        System.out.print("Enter the elements of the array: ");
        String input = scanner.nextLine();
        String[] elements = input.split("\\s+");

        // Convert the string array to an integer array
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            try {
                arr[i] = Integer.parseInt(elements[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + elements[i]);
                return; // Exit if there's an invalid number
            }
        }

        // Print the original array
        System.out.println("Original array: " + Arrays.toString(arr));

        // Check for duplicates
        boolean hasDuplicates = containsDuplicates(arr);

        // Print the result
        if (hasDuplicates) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    // Method to check if the array contains duplicates
    private static boolean containsDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates
    }
}
