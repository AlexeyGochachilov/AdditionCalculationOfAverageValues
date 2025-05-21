package MainPackage;

import UtilPackage.Calculate;
import IO.ReadFile;
import IO.WriteFile;
import Stock.Stock;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Calculate calc = new Calculate();
        Date date = new Date();
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String dateString = formatter.format(date);

        Path pathOut = Path.of("D:\\market_info\\info_" + dateString + ".txt");
        Path pathIn = Path.of("D:\\NEW_JAVA\\AdditionCalculationOfAverageValues\\StocksInfo.txt");
        Iterator<Stock> stockIterator = readFile.creatingListFromFile(pathIn.toString()).iterator();

        System.out.println("Starting the program...");

        while (stockIterator.hasNext()) {
            calc.calculateAverageValues(stockIterator.next());
            sb.append(calc.getStringBuilder());
        }

        System.out.println("Exiting the program.");

        sb.append(calc.getCountNormalDeal()).append(". Company with normal deal: ")
                .append(calc.getInfoNormalDeal()).append("\n");
        sb.append(calc.getCountGoodDeal()).append(". Company with good deal: ")
                .append(calc.getInfoGoodDeal()).append("\n");

        writeFile.writeToFile(pathOut.toString(), sb.toString());
    }
}

