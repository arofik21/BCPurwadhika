package com.arofik.Day6;

import java.util.Scanner;

public class StringReverse {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the string input from the user
        System.out.print("Enter the string to reverse: ");
        String input = scanner.nextLine();

        // Reverse the string manually
        String reversed = reverseString(input);

        // Print the reversed string
        System.out.println("Reversed string: " + reversed);
    }

    // Method to reverse a string
    private static String reverseString(String str) {
        char[] characters = str.toCharArray(); // Convert string to character array
        int left = 0; // Starting index
        int right = characters.length - 1; // Ending index

        // Swap characters from start and end
        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            left++;
            right--;
        }

        return new String(characters); // Convert character array back to string
    }
}
