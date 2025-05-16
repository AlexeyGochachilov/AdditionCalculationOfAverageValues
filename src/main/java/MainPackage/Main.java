package MainPackage;

import CalculatePackage.Calculate;
import Stock.Stock;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Calculate calc = new Calculate();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String dateString = formatter.format(date);
        Path pathOut = Path.of("D:\\market_info\\info_" + dateString + ".txt");
        Path pathIn = Path.of("D:\\NEW_JAVA\\AdditionCalculationOfAverageValues\\StocksInfo.txt");
        List<Stock> stockList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stockConstr = line.split(" ");
                Stock stock = new Stock(stockConstr[0], stockConstr[1], stockConstr[2], stockConstr[3]);
                stockList.add(stock);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Iterator<Stock> stockIterator = stockList.iterator();

        while (stockIterator.hasNext()) {

            calc.calculateAverageValues(stockIterator.next());
            sb.append(calc.getStringBuilder());
        }

        System.out.println("Exiting the program.");
        sb.append(calc.getCountNormalDeal()).append(". Company with normal deal: ")
                .append(calc.getInfoNormalDeal()).append("\n");
        sb.append(calc.getCountGoodDeal()).append(". Company with good deal: ")
                .append(calc.getInfoGoodDeal()).append("\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut.toString(), true))) {
            writer.write(sb.toString());
            System.out.println("Data saved to path: " + pathOut);
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

