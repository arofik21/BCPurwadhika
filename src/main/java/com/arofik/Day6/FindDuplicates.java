package com.arofik.Day6;

import java.util.*;

public class FindDuplicates {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the array elements from the user
        System.out.print("Enter the elements of the array separated by spaces: ");
        String input = scanner.nextLine();
        String[] elements = input.split("\\s+");

        // Convert the string array to an Integer array
        List<Integer> list = new ArrayList<>();
        for (String element : elements) {
            try {
                list.add(Integer.parseInt(element));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + element);
                return; // Exit if there's an invalid number
            }
        }

        // Find duplicates
        List<Integer> duplicates = findDuplicates(list);

        // Print the duplicates
        System.out.println("Duplicates: " + duplicates);
    }

    // Method to find duplicates in a list
    private static List<Integer> findDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return new ArrayList<>(duplicates); // Convert set to list
    }
}
