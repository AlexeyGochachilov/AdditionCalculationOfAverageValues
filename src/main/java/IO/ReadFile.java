package IO;

import Stock.Stock;
import UtilPackage.CreatedStockFromString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements CreatedStockFromString {

    /**
     * This method reads stock data from a file and creates a list of Stock objects.
     * Each line in the file should contain stock information in the format: "name nowValue 52WHigh 52WLow".
     * If the line does not conform to this format, it will be skipped with an error message.
     *
     * @param filePath The path to the file containing stock data.
     * @return A list of Stock objects created from the file data.
     */
    public List<Stock> creatingListFromFile(String filePath) {

        List<Stock> stockList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stockConstr = line.trim().split("\\s+");
                if (stockConstr.length != 4 && stockConstr.length != 7) {
                    System.out.println("This line don't have Stock: " + line);
                    continue; // Skip this line and continue with the next
                }
                try {
                    Stock stock = createStockFromString(replaceToDot(stockConstr));
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
