package com.arofik.Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayRemoveOccurrences {
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

        // Get the key to remove from the user
        System.out.print("Enter the element to remove: ");
        int key = scanner.nextInt();

        // Remove all occurrences of the key
        list.removeIf(num -> num == key);

        // Convert the list back to an array
        Integer[] resultArray = list.toArray(new Integer[0]);

        // Print the updated array
        System.out.println("Array after removing all occurrences of " + key + ": " + Arrays.toString(resultArray));
    }
}
