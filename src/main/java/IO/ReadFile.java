package IO;

import Stock.Stock;

import java.io.*;
import java.util.*;

public class ReadFile {

    public List<Stock> creatingListFromFile(String filePath) {

        List<Stock> stockList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line, A, B, C, MAX, MIN;
            while ((line = reader.readLine()) != null) {
                String[] stockConstr = line.trim().split(" ");
                if (stockConstr.length != 4) {
                    System.out.println("Invalid line format: " + line);
                    continue; // Skip this line and continue with the next
                }
try {
                Stock stock = null;
                A = stockConstr[1];
                B = stockConstr[2];
                C = stockConstr[3];
                MAX = "" + (Math.max (Math.max(Double.parseDouble(A), Double.parseDouble(B)), Double.parseDouble(C)));
                MIN = "" + (Math.min (Math.min(Double.parseDouble(A), Double.parseDouble(B)), Double.parseDouble(C)));
                if (Double.parseDouble(A) < Double.parseDouble(MAX) && Double.parseDouble(A) > Double.parseDouble(MIN)) {
                        stock = new Stock(stockConstr[0], A, MAX, MIN);
                    }  else if (Double.parseDouble(B) < Double.parseDouble(MAX) && Double.parseDouble(B) > Double.parseDouble(MIN)) {
                        stock = new Stock(stockConstr[0], B, MAX, MIN);
                    } else if (Double.parseDouble(C) < Double.parseDouble(MAX) && Double.parseDouble(C) > Double.parseDouble(MIN)) {
                        stock = new Stock(stockConstr[0], C, MAX, MIN);
                }
                if (stock != null) {
        stockList.add(stock);
    }
} catch (NumberFormatException e) {
    System.out.println("Invalid number format in line: " + line);
    // Можно добавить логирование или другие действия по необходимости
}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stockList;
    }
}
