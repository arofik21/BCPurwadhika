package com.arofik.Day5;

import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_EUR = 0.92;
    private static final double EUR_TO_USD = 0.64;
    private static final double USD_TO_GBP = 0.79;
    private static final double USD_TO_JPY = 147.65;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (USD, EUR, GBP, or JPY): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP, or JPY): ");
        String targetCurrency = scanner.next().toUpperCase();

        double result = convertCurrency(amount, sourceCurrency, targetCurrency);

        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, sourceCurrency, result, targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double amountInUSD = convertToUSD(amount, sourceCurrency);
        return convertFromUSD(amountInUSD, targetCurrency);
    }

    private static double convertToUSD(double amount, String currency) {
        switch (currency) {
            case "USD":
                return amount;
            case "EUR":
                return amount / EUR_TO_USD;
            case "GBP":
                return amount / USD_TO_GBP;
            case "JPY":
                return amount / USD_TO_JPY;
            default:
                throw new IllegalArgumentException("Invalid currency: " + currency);
        }
    }

    private static double convertFromUSD(double amountUSD, String currency) {
        switch (currency) {
            case "USD":
                return amountUSD;
            case "EUR":
                return amountUSD * USD_TO_EUR;
            case "GBP":
                return amountUSD * USD_TO_GBP;
            case "JPY":
                return amountUSD * USD_TO_JPY;
            default:
                throw new IllegalArgumentException("Invalid currency: " + currency);
        }
    }
}