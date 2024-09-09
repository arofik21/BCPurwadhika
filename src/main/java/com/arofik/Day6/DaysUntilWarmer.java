package com.arofik.Day6;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DaysUntilWarmer {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the temperature array from the user
        System.out.print("Enter the temperatures separated by spaces: ");
        String input = scanner.nextLine();
        String[] elements = input.split("\\s+");

        // Convert the string array to an integer array
        int[] temperatures = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            try {
                temperatures[i] = Integer.parseInt(elements[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + elements[i]);
                return; // Exit if there's an invalid number
            }
        }

        // Get the number of days to wait for a warmer temperature
        int[] result = daysUntilWarmer(temperatures);

        // Print the result
        System.out.println("Number of days to wait for a warmer temperature: " + Arrays.toString(result));
    }

    // Method to calculate the number of days until a warmer temperature
    private static int[] daysUntilWarmer(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        // The remaining indices in the stack will have a result of 0 (default value)
        return result;
    }
}
