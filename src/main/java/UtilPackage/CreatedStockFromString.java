package UtilPackage;

import Stock.Stock;

import java.math.BigDecimal;
import java.util.Arrays;

public interface CreatedStockFromString {

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
            stock = new Stock(stockConstr[0], b, MAX, MIN);
        } else if (c.compareTo(MAX) < 0 && c.compareTo(MIN) > 0) {
            stock = new Stock(stockConstr[0], c, MAX, MIN);
        }
        return stock;
    }

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
