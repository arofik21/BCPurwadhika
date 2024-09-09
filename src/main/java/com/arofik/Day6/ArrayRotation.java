package com.arofik.Day6;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Get the array elements from the user
        System.out.print("Enter the elements of the array separated by spaces: ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");

        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }

        // Get the number of rotations from the user
        System.out.print("Enter the number of left rotations: ");
        int d = scanner.nextInt();

        // Print the original array
        System.out.println("Original array: " + Arrays.toString(arr));

        // Rotate the array circularly to the left
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }

        // Print the array after rotation
        System.out.println("Array after rotation: " + Arrays.toString(arr));
    }
}