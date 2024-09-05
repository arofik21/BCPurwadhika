package com.arofik.Day4;
public class MultipleTable {
    public static void run() {
        int n = 5;
        printMultiplicationTable(n);
    }

    public static void printMultiplicationTable(int n) {
        // Loop through rows
        for (int i = 1; i <= n; i++) {
            // Loop through columns
            for (int j = 1; j <= n; j++) {
                // Print the product of i and j
                System.out.print(i * j + " ");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}