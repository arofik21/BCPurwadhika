package com.arofik.Day1;
import java.time.LocalDate;
import java.util.Scanner;
public class GeometryAndUtilsDemo {
    public static void run() {
        // Circle calculations
        Circle circle = new Circle(5);
        System.out.printf("Circle - Diameter: %.2f, Circumference: %.4f, Area: %.3f%n",
                circle.calculateDiameter(),
                circle.calculateCircumference(),
                circle.calculateArea());
   }
}