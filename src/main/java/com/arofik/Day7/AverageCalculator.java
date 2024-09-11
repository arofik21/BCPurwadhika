import java.util.Scanner;
import java.util.ArrayList;

public class AverageCalculator {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();

        System.out.println("Masukkan angka untuk menghitung rata-rata. Ketik 'q' untuk selesai.");

        while (true) {
            System.out.print("Masukkan angka: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka yang valid atau 'q' untuk selesai.");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Tidak ada angka yang dimasukkan.");
        } else {
            double sum = 0;
            for (double number : numbers) {
                sum += number;
            }
            double average = sum / numbers.size();
            System.out.printf("Rata-rata: %.2f\n", average);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        run();
    }
}
