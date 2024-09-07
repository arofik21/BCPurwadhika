package com.arofik.Day5;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private static final String[] WORDS = {"purwadika", "belajar", "semangat"};
    private static final int MAX_ATTEMPTS = 8;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void run() {
        // Pilih kata acak dari array WORDS
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        String hiddenWord = hideWord(wordToGuess);
        int attemptsLeft = MAX_ATTEMPTS;

        System.out.println("Selamat datang di permainan Tebak Kata!");
        System.out.println("Anda memiliki " + MAX_ATTEMPTS + " kesempatan untuk menebak kata.");

        while (attemptsLeft > 0 && !hiddenWord.equals(wordToGuess)) {
            System.out.println("\nKata: " + hiddenWord);
            System.out.println("Kesempatan tersisa: " + attemptsLeft);

            char guess = getPlayerGuess();

            if (isGuessCorrect(wordToGuess, guess)) {
                System.out.println("Tebakan benar!");
                hiddenWord = updateHiddenWord(wordToGuess, hiddenWord, guess);
            } else {
                System.out.println("Tebakan salah!");
                attemptsLeft--;
            }
        }

        displayGameResult(wordToGuess, hiddenWord, attemptsLeft);
        scanner.close();
    }

    private static String hideWord(String word) {
        return word.replaceAll(".", "_");
    }

    private static char getPlayerGuess() {
        System.out.print("Masukkan tebakan Anda: ");
        return scanner.next().toLowerCase().charAt(0);
    }

    private static boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }

    private static String updateHiddenWord(String word, String hiddenWord, char guess) {
        StringBuilder updatedWord = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedWord.setCharAt(i, guess);
            }
        }
        return updatedWord.toString();
    }

    private static void displayGameResult(String word, String hiddenWord, int attemptsLeft) {
        if (hiddenWord.equals(word)) {
            System.out.println("Selamat! Anda berhasil menebak kata: " + word);
        } else {
            System.out.println("Game Over! Kata yang benar adalah: " + word);
        }
    }
}
