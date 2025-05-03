package MainPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import static CalculatePackage.Calculate.calculateAverageValues;
import static CalculatePackage.Calculate.getStringBuilder;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean isRunning = true;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Enter name Company, now value and 52 week high and low values" +
                " as (Company, 75; 100; 50): ");
        System.out.println();
        String info = scanner.nextLine();

        while (isRunning) {
            if (info.equalsIgnoreCase("exit")) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("info.txt"))) {
                    writer.write(sb.toString());
                    System.out.println("Data saved to info.txt");
                } catch (Exception e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
                isRunning = false;
                System.out.println("Exiting the program.");
            } else {
                calculateAverageValues(info);
                System.out.println("Enter name Company, now value and 52 week high and low values" +
                        " as (Company, 75; 100; 50): ");
                sb.append(getStringBuilder());
                System.out.println();
                info = scanner.nextLine();
            }
        }
    }
}
