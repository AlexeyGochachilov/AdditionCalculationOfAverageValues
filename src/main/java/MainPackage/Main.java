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
        System.out.println("1: посмотреть все акции;");
        System.out.println("2: посмотреть акции со стоимостью больше 50% от годового изменения цены;");
        System.out.println("3: посмотреть акции со стоимостью больше 37,5%, но меньше 50% от годового изменения цены;");
        System.out.println("4: посмотреть акции со стоимостью больше 25%, но меньше 37,5% от годового изменения цены;");
        System.out.println("5: посмотреть акции со стоимостью меньше 25% от годового изменения цены;");
        System.out.println("6: посмотреть акции что рекомендует Graham");
        System.out.println("7: посмотреть акции которые я выбираю в этом году для сделок");
        System.out.println("выход из программы: EXIT");
    }

    private static void command(String string) throws IOException {

        switch (string) {
            case "1":
                for (Stock stock : calc.getAllStockSet()) {
                    System.out.println(stock);
                    writeFile.writeToFile(pathOut.toString(), stock.toString());
                }
                break;
            case "2":
                System.out.println(calc.getCountBadDeal());
                for (Stock stock : calc.getBadDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "3":
                System.out.println(calc.getCountNotGoodDeal());
                for (Stock stock : calc.getNotGoodDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "4":
                System.out.println(calc.getCountNormalDeal());
                for (Stock stock : calc.getNormalDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "5":
                System.out.println(calc.getCountGoodDeal());
                for (Stock stock : calc.getGoodDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "6":
                System.out.println(calc.getCountGrahamGodDeal());
                for (Stock stock : calc.getGrahamDealStockList()) {
                    System.out.println(stock);
                }
                break;
            case "7":
                writeFile.writeToFile(pathOut.toString(), "\n" + "то что подходит для моих сделок" + "\n" + "\n");
                if (findSameStock(calc, calc.getGrahamDealStockList(), calc.getGoodDealStockList()).size() < 3){
                    for(Stock st : findSameStock(calc, calc.getGrahamDealStockList(), calc.getGoodDealStockList(),
                            calc.getNormalDealStockList())){
                        System.out.println(st);
                        writeFile.writeToFile(pathOut.toString(), st.toString());
                    }
                } else for (Stock st : (findSameStock(calc, calc.getGrahamDealStockList(), calc.getGoodDealStockList()))){
                    System.out.println(st);
                    writeFile.writeToFile(pathOut.toString(), st.toString());
                }
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
}

