package MainPackage;

import CalculatePackage.Calculate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean isRunning = true;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Calculate calc = new Calculate();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String dateString = formatter.format(date);
        Path path = Path.of("D:\\market_info\\info" + dateString + ".txt");

        System.out.println();
        System.out.println("Enter name Company, now value and 52 week high and low values" +
                " as (Company, 75; 100; 50): ");
        System.out.println();
        String info = scanner.nextLine();

        while (isRunning) {
            if (info.equalsIgnoreCase("exit")) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString(), true))) {
                    writer.write(sb.toString());
                    System.out.println("Data saved to info.txt");
                } catch (Exception e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
                isRunning = false;
                System.out.println("Exiting the program.");
            } else {
                calc.calculateAverageValues(info);
                System.out.println("Enter name Company, now value and 52 week high and low values" +
                        " as (Company, 75; 100; 50): ");
                sb.append(calc.getStringBuilder());
                System.out.println();
                info = scanner.nextLine();
            }
        }
    }
}
