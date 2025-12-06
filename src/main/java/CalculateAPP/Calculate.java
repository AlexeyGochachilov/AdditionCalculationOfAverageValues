package CalculateAPP;

import Security.Stock;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;

@Getter
public abstract class Calculate {

    /**
     * This class is used to calculate the average values of stocks and categorize them
     * into different deal types based on their current value compared to their max and min values.
     */

    protected List<Stock> badDealStockList = new LinkedList<>();
    protected List<Stock> notGoodDealStockList = new LinkedList<>();
    protected List<Stock> normalDealStockList = new LinkedList<>();
    protected List<Stock> goodDealStockList = new LinkedList<>();
    protected List<Stock> grahamDealStockList = new LinkedList<>();
    protected List<Stock> allStockList = new LinkedList<>();
    protected int countGoodDeal = 0;
    protected int countNotGoodDeal = 0;
    protected int countBadDeal = 0;
    protected int countNormalDeal = 0;
    protected int countGrahamGodDeal = 0;
    protected BigDecimal MAXValue = null;
    protected BigDecimal MINValue = null;
    protected BigDecimal novValue = null;
    protected BigDecimal novValueCounting = null;

    /**
     * This method calculates the percentage of the current stock value relative to its max and min values.
     * It returns a BigDecimal representing the percentage.
     */
    public static BigDecimal nowPercent(Stock stock) {
        BigDecimal result = stock.getMaxValue().subtract(stock.getMinValue());
        BigDecimal nowResult = stock.getNowValue().subtract(stock.getMinValue());
        BigDecimal hundred = new BigDecimal("100");
        return nowResult.multiply(hundred).divide(result, 4, java.math.RoundingMode.HALF_UP);
    }

    /**
     * This method calculates the average values of a stock and categorizes it into different deal types.
     * It updates the stringBuilder with the results and categorizes the stock based on its current value.
     */

    public void calculateAverageValues(Stock stock) {
    }
}
