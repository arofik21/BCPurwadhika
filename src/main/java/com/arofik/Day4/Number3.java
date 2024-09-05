package com.arofik.Day4;
import java.util.Scanner;

public class Number3 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int angka = 1;
        String input;

        do {
            System.out.print(angka + " (tekan y untuk melanjutkan), " + (angka + 1) + " (tekan n untuk berhenti) → ");
            input = scanner.nextLine();

            if (input.equals("y")) {
                System.out.print(angka + ", ");
                angka++;
            } else if (!input.equals("n")) {
                System.out.println("Input tidak valid. Silakan masukkan y atau n.");
            }
        } while (!input.equals("n"));

        System.out.println(angka);
        scanner.close();
    }
}