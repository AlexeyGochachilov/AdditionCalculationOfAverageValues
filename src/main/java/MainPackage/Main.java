package MainPackage;

import UtilPackage.*;
import IO.ReadFile;
import IO.WriteFile;
import Stock.Stock;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import static UtilPackage.OpenFile.openFile;

public class Main {

    /**
     * This is the main class of the program that calculates stock values and categorizes them into different deal types.
     * It reads stock information from a file, processes it, and writes the results to an output file.
     */
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Calculate calc = new Calculate();
        Date date = new Date();
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String dateString = formatter.format(date);

        Path pathOut = Path.of("D:\\market_info\\info_" + dateString + ".txt");
        Path pathIn = Path.of("src/main/resources/StocksInfo.txt");
        Iterator<Stock> stockIterator = readFile.creatingListFromFile(pathIn.toString()).iterator();

        System.out.println("Starting the program...");

        while (stockIterator.hasNext()) {
            calc.calculateAverageValues(stockIterator.next());
            sb.append(calc.getStringBuilder());
        }
        sb.append(calc.getCountBadDeal()).append(". Company with bad deal: ")
                .append(calc.getInfoBadDeal()).append("\n");
        sb.append(calc.getCountNotGoodDeal()).append(". Company with not good deal: ")
                .append(calc.getInfoNotGoodDeal()).append("\n");
        sb.append(calc.getCountNormalDeal()).append(". Company with normal deal: ")
                .append(calc.getInfoNormalDeal()).append("\n");
        sb.append(calc.getCountGoodDeal()).append(". Company with good deal: ")
                .append(calc.getInfoGoodDeal()).append("\n");

        writeFile.writeToFile(pathOut.toString(), sb.toString());

        openFile(pathOut);

        System.out.println("Exiting the program.");
    }
}

