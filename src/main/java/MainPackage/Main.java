package MainPackage;

import CalculateAPP.*;
import Interfaces.*;
import IO.*;
import Stock.Stock;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import static IO.OpenFile.openFile;
import static UtilPackage.ComparatorStock.findSameStock;

public class Main {

    /**
     * This is the main class of the program that calculates stock values and categorizes them into different deal types.
     * It reads stock information from a file, processes it, and writes the results to an output file.
     */

    static Calculate calc = new CalculateIMPL();
    static WriteFile writeFile = new WriteFileIMPL();
    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
    static String dateString = formatter.format(date);
    private static BufferedReader br;
    static ReadFile readFile = new ReadFileIMPL();
    static Path pathIn = Path.of("src/main/resources/StocksInfo.txt");
    static Path pathOut = AppConfig.getOutputPath(dateString);

    public static void main(String[] args) {

        System.out.println("Starting the program...");
        Iterator<Stock> stockIterator = readFile.creatingListFromFile(pathIn.toString()).iterator();
        System.out.println();
        while (stockIterator.hasNext()) {
            calc.calculateAverageValues(stockIterator.next());
        }

        printNavigation();
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program.");
    }

    private static void printNavigation() {
        System.out.println("Управление навигацией:");
        System.out.println("1.1: посмотреть все акции;");
        System.out.println("1.2: посмотреть все акции и записать информацию в файл;");
        System.out.println("2: посмотреть акции со стоимостью больше 50% от годового изменения цены;");
        System.out.println("3: посмотреть акции со стоимостью больше 37,5%, но меньше 50% от годового изменения цены;");
        System.out.println("4: посмотреть акции со стоимостью больше 25%, но меньше 37,5% от годового изменения цены;");
        System.out.println("5: посмотреть акции со стоимостью меньше 25% от годового изменения цены;");
        System.out.println("6: посмотреть акции что рекомендует Graham;");
        System.out.println("7.1: посмотреть акции которые я выбираю в этом году для сделок;");
        System.out.println("7.2: посмотреть акции которые я выбираю в этом году для сделок и записать информацию в файл;");
        System.out.println("выключение программы: OFF");
        System.out.println("выход из программы: EXIT");
    }

    private static void command(String string) throws IOException {

        switch (string) {
            case "1.1", "1,1":
                for (Stock stock : calc.getAllStockList()) {
                    System.out.println(stock);
                }
                break;
            case "1.2", "1,2":
                for (Stock stock : calc.getAllStockList()) {
                    System.out.println(stock);
                    writeFile.writeToFile(pathOut.toString(), stock.toString());
                }
                break;
            case "2":
                System.out.print(calc.getCountBadDeal() + " ");
                System.out.println(endsOfStocks(calc.getCountBadDeal()));
                for (Stock stock : calc.getBadDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "3":
                System.out.print(calc.getCountNotGoodDeal() + " ");
                System.out.println(endsOfStocks(calc.getCountNotGoodDeal()));
                for (Stock stock : calc.getNotGoodDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "4":
                System.out.print(calc.getCountNormalDeal() + " ");
                System.out.println(endsOfStocks(calc.getCountNormalDeal()));
                for (Stock stock : calc.getNormalDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "5":
                System.out.print(calc.getCountGoodDeal() + " ");
                System.out.println(endsOfStocks(calc.getCountGoodDeal()));
                for (Stock stock : calc.getGoodDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "6":
                System.out.print(calc.getCountGrahamGodDeal() + " ");
                System.out.println(endsOfStocks(calc.getCountGrahamGodDeal()));
                for (Stock stock : calc.getGrahamDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "7.1", "7,1":
                if (findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList()).size() <= 3) {
                    for (Stock st : findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList(),
                            calc.getNormalDealStockList())) {
                        System.out.println(st);
                    }
                } else
                    for (Stock st : (findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList()))) {
                        System.out.println(st);
                    }
                break;
            case "7.2", "7,2":
                writeFile.writeToFile(pathOut.toString(), "\n" + "то что подходит для моих сделок" + "\n" + "\n");
                if (findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList()).size() <= 3) {
                    for (Stock st : findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList(),
                            calc.getNormalDealStockList())) {
                        System.out.println(st);
                        writeFile.writeToFile(pathOut.toString(), st.toString());
                    }
                } else
                    for (Stock st : (findSameStock(calc.getGrahamDealStockList(), calc.getGoodDealStockList()))) {
                        System.out.println(st);
                        writeFile.writeToFile(pathOut.toString(), st.toString());
                    }
                break;
            case "OFF", "off", "щаа", "ЩАА":
                System.exit(1);
                break;
            case "EXIT", "exit", "учше", "УЧШЕ":
                openFile(pathOut);
                System.exit(1);
                break;
            default:
                System.out.println("ввели не подходящий символ");
        }
        printNavigation();
        command(br.readLine());
    }

    private static String endsOfStocks(int i) {
        return switch (i) {
            case 1 -> "акция:";
            case 2, 3, 4 -> "акции:";
            default -> "акций:";
        };
    }
}

