package Interfaces;

import Security.Stock;

public interface CreatedStockFromString {

    /**
     * This method creates a Stock object from a string array containing stock information.
     * The array should contain the stock name, current value, 52-week high, and 52-week low.
     * It validates the values and returns a Stock object if valid, or null if invalid.
     *
     * @param stockConstr An array of strings containing stock information.
     * @return A Stock object or null if the input is invalid.
     */
    Stock createStockFromString(String[] stockConstr);

    /**
     * This method replaces commas with dots in the stock values in the provided string array.
     * It is used to ensure that the string representations of numbers are in a format that can be parsed as BigDecimal.
     *
     * @param stockConstr An array of strings containing stock information.
     * @return The modified array with commas replaced by dots.
     */
    String[] replaceToDot(String[] stockConstr);
}
