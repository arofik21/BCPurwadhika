package com.arofik.Day5;

import java.util.Arrays;

public class EvenNumberFilter {
    public static int[] removeOddNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .toArray();
    }

    public static void run() {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evenArray = removeOddNumbers(originalArray);

        System.out.println("Array asli: " + Arrays.toString(originalArray));
        System.out.println("Array hanya genap: " + Arrays.toString(evenArray));
    }
}