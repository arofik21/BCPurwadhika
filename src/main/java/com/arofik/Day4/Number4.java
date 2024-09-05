package com.arofik.Day4;

import java.util.Random;
import java.util.Scanner;

public class Number4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int targetAngka = random.nextInt(100) + 1;
        int tebakan;
        int jumlahTebakan = 0;

        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 dan 100. Coba tebak!");

        do {
            System.out.print("Masukkan tebakan Anda: ");
            tebakan = scanner.nextInt();
            jumlahTebakan++;

            if (tebakan < targetAngka) {
                System.out.println("Terlalu rendah! Coba lagi.");
            } else if (tebakan > targetAngka) {
                System.out.println("Terlalu tinggi! Coba lagi.");
            } else {
                System.out.println("Selamat! Anda benar!");
                System.out.println("Anda menebak angka dalam " + jumlahTebakan + " percobaan.");
            }
        } while (tebakan != targetAngka);

        scanner.close();
    }
}