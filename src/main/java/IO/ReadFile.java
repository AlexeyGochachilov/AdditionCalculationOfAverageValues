package IO;

import Stock.Stock;

import java.io.*;
import java.util.*;

public class ReadFile {

    public List<Stock> creatingListFromFile(String filePath) {

        List<Stock> stockList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line, A, B, C;
            while ((line = reader.readLine()) != null) {
                String[] stockConstr = line.trim().split(" ");
                if (stockConstr.length != 4) {
                    System.out.println("Invalid line format: " + line);
                    continue; // Skip this line and continue with the next
                }
                Stock stock = null;
                A = stockConstr[1];
                B = stockConstr[2];
                C = stockConstr[3];
                if (Double.parseDouble(A) < Double.parseDouble(B)) {
                    if (Double.parseDouble(A) > Double.parseDouble(C)) {
                        stock = new Stock(stockConstr[0], A, B, C);
                    } else if (Double.parseDouble(B) < Double.parseDouble(C)) {
                        stock = new Stock(stockConstr[0], B, C, A);
                    } else if (Double.parseDouble(C) > Double.parseDouble(A)) {
                        stock = new Stock(stockConstr[0], C, B, A);
                    }
                } else if (Double.parseDouble(A) > Double.parseDouble(B)) {
                    if (Double.parseDouble(B) > Double.parseDouble(C)) {
                        stock = new Stock(stockConstr[0], B, A, C);
                    } else if (Double.parseDouble(C) > Double.parseDouble(A)) {
                        stock = new Stock(stockConstr[0], A, C, B);
                    } else if (Double.parseDouble(C) > Double.parseDouble(B)) {
                        stock = new Stock(stockConstr[0], C, A, B);
                    }
                }
                stockList.add(stock);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stockList;
    }
}
