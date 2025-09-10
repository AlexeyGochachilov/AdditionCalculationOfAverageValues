package MainPackage;

import Interfaces.ReadFile;
import Interfaces.WriteFile;
import UtilPackage.*;
import IO.*;
import Stock.Stock;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import static IO.OpenFile.openFile;
import static UtilPackage.StringComparator.findCommonWords;

public class Main {

    /**
     * This is the main class of the program that calculates stock values and categorizes them into different deal types.
     * It reads stock information from a file, processes it, and writes the results to an output file.
     */
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        CalculateIMPL calc = new CalculateIMPL();
        ReadFile readFile = new ReadFileIMPL();
        WriteFile writeFile = new WriteFileIMPL();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
        String dateString = formatter.format(date);
        String veryGodDeal;

        try {
            Path pathOut = AppConfig.getOutputPath(dateString);
            Path pathIn = Path.of("src/main/resources/StocksInfo.txt");
            Iterator<Stock> stockIterator = readFile.creatingListFromFile(pathIn.toString()).iterator();

            System.out.println("Starting the program...");

            while (stockIterator.hasNext()) {
                calc.calculateAverageValues(stockIterator.next());
                sb.append(calc.getStringBuilders()).append("\n");
            }
            if (findCommonWords(calc.getInfoGrahamGodDeal(), calc.getInfoGoodDeal()).split("\\s+").length < 3) {
                veryGodDeal = "before 0.375% " + findCommonWords(calc.getInfoGrahamGodDeal(), calc.getInfoGoodDeal(), calc.getInfoNormalDeal());
            } else veryGodDeal = "before 0.25% " + findCommonWords(calc.getInfoGrahamGodDeal(), calc.getInfoGoodDeal());

            sb.append(calc.getCountBadDeal()).append(". Company with bad deal: ")
                    .append(calc.getInfoBadDeal()).append("\n");
            sb.append(calc.getCountNotGoodDeal()).append(". Company with not good deal: ")
                    .append(calc.getInfoNotGoodDeal()).append("\n");
            sb.append(calc.getCountNormalDeal()).append(". Company with normal deal: ")
                    .append(calc.getInfoNormalDeal()).append("\n");
            sb.append(calc.getCountGoodDeal()).append(". Company with good deal: ")
                    .append(calc.getInfoGoodDeal()).append("\n");
            sb.append(calc.getCountGrahamGodDeal()).append(". Company with good deal from Graham: ")
                    .append(calc.getInfoGrahamGodDeal()).append("\n\n");
            sb.append("Very good deal: ").append(veryGodDeal);

            writeFile.writeToFile(pathOut.toString(), sb.toString());
            openFile(pathOut);
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Exiting the program.");
    }
}

