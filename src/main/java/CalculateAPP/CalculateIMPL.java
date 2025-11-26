package CalculateAPP;

import Stock.Stock;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CalculateIMPL extends Calculate {

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
     * This method calculates a value based on a percentage string input.
     * It returns a BigDecimal representing the calculated value.
     */
    public BigDecimal percent(String s) {
        BigDecimal result = MAXValue.subtract(MINValue);
        return result.multiply(new BigDecimal(s)).add(MINValue);
    }

    /**
     * This method calculates the average values of a stock and categorizes it into different deal types.
     * It updates the stringBuilder with the results and categorizes the stock based on its current value.
     */

    @Override
    public void calculateAverageValues(Stock stock) {

        MAXValue = stock.getMaxValue();
        MINValue = stock.getMinValue();
        novValue = stock.getNowValue();

        if (stock.getPE() != null) {
            if (stock.getPE().doubleValue() > 5 && stock.getPE().doubleValue() < 15) {
                double sum1 = (stock.getEPS().doubleValue() *
                        (15 + 2 * (stock.getEpsFrom5Years().doubleValue() * 0.6)) * 4.4) / 12;
                novValueCounting = new BigDecimal(sum1).setScale(4, java.math.RoundingMode.HALF_UP);

                if (novValue.compareTo(novValueCounting) < 0) {
                    grahamDealStockList.add(stock);
                    countGrahamGodDeal++;
                }

            }
        }

        BigDecimal halfResult = percent("0.5");
        BigDecimal quarterResult = percent("0.25");
        BigDecimal threeEighthsResult = percent("0.375");

        if (novValue.compareTo(halfResult) >= 0) {
            badDealStockList.add(stock);
            countBadDeal++;
        } else if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(threeEighthsResult) >= 0) {
            notGoodDealStockList.add(stock);
            countNotGoodDeal++;
        } else if (novValue.compareTo(threeEighthsResult) < 0 && novValue.compareTo(quarterResult) >= 0) {
            normalDealStockList.add(stock);
            countNormalDeal++;
        } else {
            goodDealStockList.add(stock);
            countGoodDeal++;
        }

        allStockSet.addAll(badDealStockList);
        allStockSet.addAll(notGoodDealStockList);
        allStockSet.addAll(normalDealStockList);
        allStockSet.addAll(goodDealStockList);
    }
}
