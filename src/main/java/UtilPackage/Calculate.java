package UtilPackage;

import Stock.Stock;

import java.math.BigDecimal;

public class Calculate {

    /**
     * This class is used to calculate the average values of stocks and categorize them
     * into different deal types based on their current value compared to their max and min values.
     */

    private static String stringBuilder;
    private static StringBuilder infoGoodDeal = new StringBuilder();
    private static StringBuilder infoBadDeal = new StringBuilder();
    private static StringBuilder infoNotGoodDeal = new StringBuilder();
    private static StringBuilder infoNormalDeal = new StringBuilder();
    private int countGoodDeal = 0;
    private int countNotGoodDeal = 0;
    private int countBadDeal = 0;
    private int countNormalDeal = 0;
    private BigDecimal MAXValue = null;
    private BigDecimal MINValue = null;
    private BigDecimal novValue = null;
    private BigDecimal novValueCounting = null;

    public String getInfoBadDeal() {
        return infoBadDeal.toString();
    }

    public String getInfoNotGoodDeal() {
        return infoNotGoodDeal.toString();
    }

    public int getCountNotGoodDeal() {
        return countNotGoodDeal;
    }

    public int getCountBadDeal() {
        return countBadDeal;
    }

    public String getInfoGoodDeal() {
        return infoGoodDeal.toString();
    }

    public String getInfoNormalDeal() {
        return infoNormalDeal.toString();
    }

    public int getCountGoodDeal() {
        return countGoodDeal;
    }

    public int getCountNormalDeal() {
        return countNormalDeal;
    }

    public String getStringBuilder() {
        return stringBuilder;
    }

    /**
     * This method calculates the percentage of the current stock value relative to its max and min values.
     * It returns a BigDecimal representing the percentage.
     */
    private BigDecimal nowPercent() {
        BigDecimal result = MAXValue.subtract(MINValue);
        BigDecimal nowResult = novValue.subtract(MINValue);
        BigDecimal hundred = new BigDecimal("100");
        return nowResult.multiply(hundred).divide(result, 4, java.math.RoundingMode.HALF_UP);
    }

    /**
     * This method calculates a value based on a percentage string input.
     * It returns a BigDecimal representing the calculated value.
     */
    private BigDecimal percent(String s) {
        BigDecimal result = MAXValue.subtract(MINValue);
        return result.multiply(new BigDecimal(s)).add(MINValue);
    }

    /**
     * This method calculates the average values of a stock and categorizes it into different deal types.
     * It updates the stringBuilder with the results and categorizes the stock based on its current value.
     */
    public void calculateAverageValues(Stock stock) {

        StringBuilder sb = new StringBuilder(stock.getName()).append("\n");
        String companyName = stock.getName();

        MAXValue = stock.getMaxValue();
        MINValue = stock.getMinValue();
        novValue = stock.getNowValue();

        String stringNovValueCounting = "";
        if (stock.getPE() != null) {
            if (stock.getPE().doubleValue() > 5 && stock.getPE().doubleValue() < 15) {
                double sum1 = stock.getEPS().doubleValue() *
                        (15 + 2 * (stock.getEpsFrom5Years().doubleValue() * 0.6)) * 4.4 / 12;
                novValueCounting = new BigDecimal(sum1).setScale(4, java.math.RoundingMode.HALF_UP);
                stringNovValueCounting = " novValueCounting = " + novValueCounting + "\n";
            }
        }


        BigDecimal halfResult = percent("0.5");
        BigDecimal quarterResult = percent("0.25");
        BigDecimal threeEighthsResult = percent("0.375");

        String stringNowValue = "--> Nov   = " + novValue + " (" + nowPercent() + "%)";
        String stringMAXValue = "52 w High = " + MAXValue;
        String stringMINValue = "52 w Low  = " + MINValue;

        sb.append(stringMAXValue).append("\n");

        if (novValue.compareTo(halfResult) >= 0) {

            sb.append(stringNowValue).append(" не выгодная сделка").append("\n")
                    .append(stringNovValueCounting);
            infoBadDeal.append(companyName).append(" ");
            countBadDeal++;

        } else if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(threeEighthsResult) >= 0) {

            sb.append(stringNowValue).append(" не очень выгодная сделка").append("\n")
                    .append(stringNovValueCounting);
            infoNotGoodDeal.append(companyName).append(" ");
            countNotGoodDeal++;

        } else if (novValue.compareTo(threeEighthsResult) < 0 && novValue.compareTo(quarterResult) >= 0) {

            sb.append(stringNowValue).append(" нормальная сделка").append("\n")
                    .append(stringNovValueCounting);
            infoNormalDeal.append(companyName).append(" ");
            countNormalDeal++;

        } else {

            sb.append(stringNowValue).append(" очень выгодная сделка").append("\n")
                    .append(stringNovValueCounting);
            infoGoodDeal.append(companyName).append(" ");
            countGoodDeal++;

        }

        sb.append(stringMINValue).append("\n");
        stringBuilder = sb.toString();
    }
}
