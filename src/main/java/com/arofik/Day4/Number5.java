package com.arofik.Day4;
public class Number5 {
    public static void run() {
        String input = "The QuiCk BrOwN Fox";
        String hasil = swapCase(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + hasil);
    }

    public static String swapCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }
}