package CalculateAPP;

import Stock.Stock;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;

@Getter
public abstract class Calculate {

    /**
     * This class is used to calculate the average values of stocks and categorize them
     * into different deal types based on their current value compared to their max and min values.
     */

    protected String stringBuilders;
//    protected StringBuilder infoGoodDeal = new StringBuilder();
//    protected StringBuilder infoBadDeal = new StringBuilder();
//    protected StringBuilder infoNotGoodDeal = new StringBuilder();
//    protected StringBuilder infoNormalDeal = new StringBuilder();
//    protected StringBuilder infoGrahamGodDeal = new StringBuilder();
    protected List<Stock> badDealStockList = new ArrayList<>();
    protected List<Stock> notGoodDealStockList = new ArrayList<>();
    protected List<Stock> normalDealStockList = new ArrayList<>();
    protected List<Stock> goodDealStockList = new ArrayList<>();
    protected List<Stock> grahamDealStockList = new ArrayList<>();
    protected Set<Stock> allStockList = new LinkedHashSet<>();
    protected int countGoodDeal = 0;
    protected int countNotGoodDeal = 0;
    protected int countBadDeal = 0;
    protected int countNormalDeal = 0;
    protected int countGrahamGodDeal = 0;
    protected BigDecimal MAXValue = null;
    protected BigDecimal MINValue = null;
    protected BigDecimal novValue = null;
    protected BigDecimal novValueCounting = null;

//    public String getInfoBadDeal() {
//        return infoBadDeal.toString();
//    }

//    public String getInfoNotGoodDeal() {
//        return infoNotGoodDeal.toString();
//    }

//    public String getInfoGoodDeal() {
//        return infoGoodDeal.toString();
//    }

//    public String getInfoNormalDeal() {
//        return infoNormalDeal.toString();
//    }

//    public String getInfoGrahamGodDeal() {
//        return infoGrahamGodDeal.toString();
//    }

    /**
     * This method calculates the average values of a stock and categorizes it into different deal types.
     * It updates the stringBuilder with the results and categorizes the stock based on its current value.
     */

    public void calculateAverageValues(Stock stock) {}
}
