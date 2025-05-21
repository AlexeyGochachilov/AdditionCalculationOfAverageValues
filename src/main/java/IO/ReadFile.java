package IO;

import Stock.Stock;
import UtilPackage.CreatedStockFromString;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ReadFile implements CreatedStockFromString {

    public List<Stock> creatingListFromFile(String filePath) {

        List<Stock> stockList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stockConstr = line.trim().split(" ");
                if (stockConstr.length != 4) {
                    System.out.println("This line don't have Stock: " + line);
                    continue; // Skip this line and continue with the next
                }
                for (int i = 1; i < stockConstr.length; i++) {
                    try {
                        stockConstr[i] = stockConstr[i].replace(",", ".");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format in line: " + line);
                        // Можно добавить логирование или другие действия по необходимости
                    }
                }
                try {
                    Stock stock = createStockFromString(stockConstr);
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
