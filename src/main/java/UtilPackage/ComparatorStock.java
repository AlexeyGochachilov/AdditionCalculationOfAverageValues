package UtilPackage;

import Security.Stock;

import java.util.*;

public class ComparatorStock {

    public static Set<Stock> findSameStock(List<Stock> list1, List<Stock> list2) {

        Set<Stock> findSame = new LinkedHashSet<>();

        for (Stock stock : list1) {
            if (list2.contains(stock)) {
                findSame.add(stock);
            }
        }

        return findSame;
    }

    public static Set<Stock> findSameStock(List<Stock> list1, List<Stock> list2, List<Stock> list3) {

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
