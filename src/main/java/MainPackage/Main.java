package MainPackage;

import java.util.Scanner;

import static CalculatePackage.Calculate.calculateAverageValues;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean isRunning = true;

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Enter now value and 52 week high and low values separated by (75; 100; 50): ");
        System.out.println();
        String input = scanner.nextLine();

        while (isRunning) {
            if (input.equalsIgnoreCase("exit")) {
                isRunning = false;
                System.out.println("Exiting the program.");
            } else {
                calculateAverageValues(input);
                System.out.println("Enter now value and 52 week high and low values separated by (75; 100; 50): ");
                System.out.println();
                input = scanner.nextLine();
            }
        }
    }
}
