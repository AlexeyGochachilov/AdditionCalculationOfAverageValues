package Interfaces;

import Stock.Stock;

import java.math.BigDecimal;

public interface Calculate {

    /**
     * This method calculates the average values of a stock and categorizes it into different deal types.
     * It updates the stringBuilder with the results and categorizes the stock based on its current value.
     */
    void calculateAverageValues(Stock stock);
}
