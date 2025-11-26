package UtilPackage;

import CalculateAPP.Calculate;
import Stock.Stock;

import java.util.*;

public class ComparatorStock {

    public static Set<Stock> findSameStock(Calculate calculate, List<Stock> list1, List<Stock> list2) {

        list1 = calculate.getGrahamDealStockList();
        list2 = calculate.getGoodDealStockList();
        Set<Stock> findSame = new LinkedHashSet<>();

        for (Stock stock : list1) {
            if (list2.contains(stock)) {
                findSame.add(stock);
            }
        }

        return findSame;
    }

    public static Set<Stock> findSameStock(Calculate calculate, List<Stock> list1, List<Stock> list2, List<Stock> list3) {

        list1 = calculate.getGrahamDealStockList();
        list2 = calculate.getGoodDealStockList();
        list3 = calculate.getNormalDealStockList();
        Set<Stock> findSame = new LinkedHashSet<>();

        for (Stock stock : list1) {
            if (list2.contains(stock)) {
                findSame.add(stock);
            } else if (list3.contains(stock)) {
                findSame.add(stock);
            }
        }

        return findSame;
    }
}
