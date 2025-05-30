package UtilPackage;

import Stock.Stock;

import java.math.BigDecimal;

public class Calculate {

    private static String stringBuilder;
    private static StringBuilder infoGoodDeal = new StringBuilder();
    private static StringBuilder infoNormalDeal = new StringBuilder();
    private int countGoodDeal = 0;
    private int countNormalDeal = 0;
    private BigDecimal MAXValue = null;
    private BigDecimal MINValue = null;
    private BigDecimal novValue = null;

    public StringBuilder getInfoGoodDeal() {
        return infoGoodDeal;
    }

    public StringBuilder getInfoNormalDeal() {
        return infoNormalDeal;
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

    private BigDecimal nowPercent() {
    BigDecimal result = MAXValue.subtract(MINValue);
    BigDecimal nowResult = novValue.subtract(MINValue);
    BigDecimal hundred = new BigDecimal("100");
        return nowResult.multiply(hundred).divide(result, 2, java.math.RoundingMode.HALF_UP);
    }

    private BigDecimal percent(String s) {
        BigDecimal result = MAXValue.subtract(MINValue);
        return result.multiply(new BigDecimal(s)).add(MINValue);
    }

    public void calculateAverageValues(Stock stock) {

        StringBuilder sb = new StringBuilder(stock.getName()).append("\n");
        String companyName = stock.getName();

        novValue = stock.getNowValue();
        MAXValue = stock.getMaxValue();
        MINValue = stock.getMinValue();

        BigDecimal halfResult = percent("0.5");
        BigDecimal quarterResult = percent("0.25");
        BigDecimal threeEighthsResult = percent("0.375");

        String stringNowValue = "--> Nov   = " + novValue + " (" + nowPercent() + "%)";
        String stringMAXValue = "52 w High = " + MAXValue;
        String stringMINValue = "52 w Low  = " + MINValue;
        String fiftyPercent = "50%       = " + halfResult;
        String twentyFivePercent = "25%       = " + quarterResult;
        String threeEighthsPercent = "37.5%     = " + threeEighthsResult;

        sb.append(stringMAXValue).append("\n");
        if (novValue.compareTo(halfResult) >= 0) {
            sb.append(stringNowValue).append(" не выгодная сделка").append("\n");
        }
        sb.append(fiftyPercent).append("\n");
        if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(quarterResult) >= 0) {
            if (novValue.compareTo(threeEighthsResult) > 0) {
                sb.append(stringNowValue).append(" не очень выгодная сделка").append("\n");
                sb.append(threeEighthsPercent).append("\n");
            } else {
                sb.append(threeEighthsPercent).append("\n");
                sb.append(stringNowValue).append(" нормальная сделка").append("\n");
            }
            infoNormalDeal.append(companyName).append(" ");
            countNormalDeal++;
        }
        sb.append(twentyFivePercent).append("\n");
        if (novValue.compareTo(quarterResult) < 0) {
            sb.append(stringNowValue).append(" очень выгодная сделка").append("\n");
            infoGoodDeal.append(companyName).append(" ");
            countGoodDeal++;
        }
        sb.append(stringMINValue).append("\n");
        stringBuilder = sb.toString();
        System.out.println(stringBuilder);
    }

}
