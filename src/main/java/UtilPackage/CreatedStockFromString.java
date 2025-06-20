package UtilPackage;

import Stock.Stock;

import java.math.BigDecimal;
import java.util.Arrays;

public interface CreatedStockFromString {

    /**
     * This method creates a Stock object from a string array containing stock information.
     * The array should contain the stock name, current value, 52-week high, and 52-week low.
     * It validates the values and returns a Stock object if valid, or null if invalid.
     *
     * @param stockConstr An array of strings containing stock information.
     * @return A Stock object or null if the input is invalid.
     */
    default Stock createStockFromString(String[] stockConstr) {

        BigDecimal a, b, c, MAX, MIN;
        Stock stock = null;

        a = new BigDecimal(stockConstr[1]);
        b = new BigDecimal(stockConstr[2]);
        c = new BigDecimal(stockConstr[3]);
        MAX = a.max(b).max(c);
        MIN = a.min(b).min(c);
        if (a.compareTo(MAX) < 0 && a.compareTo(MIN) > 0) {
            stock = new Stock(stockConstr[0], a, MAX, MIN);
        } else if (b.compareTo(MAX) < 0 && b.compareTo(MIN) > 0) {
            System.out.println("Возможно в акции " + stockConstr[0] + " не верно указано значение 52 W High");
            stock = new Stock(stockConstr[0], b, MAX, MIN);
        } else if (c.compareTo(MAX) < 0 && c.compareTo(MIN) > 0) {
            System.out.println("Возможно в акции " + stockConstr[0] + " не верно указано значение 52 W Low");
            stock = new Stock(stockConstr[0], c, MAX, MIN);
        }
        return stock;
    }

    /**
     * This method replaces commas with dots in the stock values in the provided string array.
     * It is used to ensure that the string representations of numbers are in a format that can be parsed as BigDecimal.
     *
     * @param stockConstr An array of strings containing stock information.
     * @return The modified array with commas replaced by dots.
     */
    default String[] replaceToDot(String[] stockConstr) {
        for (int i = 1; i < stockConstr.length; i++) {
            try {
                stockConstr[i] = stockConstr[i].replace(",", ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in line: " + Arrays.toString(stockConstr));
            }
        }
        return stockConstr;
    }
}
