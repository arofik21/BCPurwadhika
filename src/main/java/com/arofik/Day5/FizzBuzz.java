package com.arofik.Day5;

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.print("Fizz");
            } else if (i % 5 == 0) {
                System.out.print("Buzz");
            } else {
                System.out.print(i);
            }

            // Print comma and space if it's not the last number
            if (i < n) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Print a new line at the end
    }

    public static void run() {
        System.out.println("FizzBuzz for n = 15:");
        fizzBuzz(15);

        System.out.println("\nFizzBuzz for n = 6:");
        fizzBuzz(6);
    }
}