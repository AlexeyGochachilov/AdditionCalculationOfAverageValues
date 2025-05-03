import java.math.BigDecimal;
import java.util.Scanner;

public class Calculate {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean isRunning = true;

    public static void calculateAverageValues(String string) {

        String[] values = string.trim().split("; ");
        BigDecimal novValue = new BigDecimal(values[0]);
        BigDecimal firstValue = new BigDecimal(values[1]);
        BigDecimal secondValue = new BigDecimal(values[2]);
        BigDecimal result = firstValue.subtract(secondValue);
        BigDecimal halfResult = result.divide(new BigDecimal(2)).add(secondValue);
        BigDecimal quarterResult = result.divide(new BigDecimal(4)).add(secondValue);
        String stringNowValue = "--> Nov = " + novValue;

        System.out.println();
        System.out.println("52 w High " + firstValue);
        if (novValue.compareTo(halfResult) >= 0) {
            System.out.println(stringNowValue + " не выгодная сделка");
        }
        System.out.println("50% =     " + halfResult);
        if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(quarterResult) >= 0) {
            System.out.println(stringNowValue + " выгодная сделка");
        }
        System.out.println("25% =     " + quarterResult);
        if (novValue.compareTo(quarterResult) < 0) {
            System.out.println(stringNowValue + " очень выгодная сделка");
        }
        System.out.println("52 w Low  " + secondValue);
        System.out.println();
    }

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
