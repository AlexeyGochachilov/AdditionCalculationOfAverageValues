package CalculatePackage;

import Stock.Stock;

import java.math.BigDecimal;

public class Calculate {

    private static String stringBuilder;
    private static StringBuilder infoGoodDeal = new StringBuilder();
    private static StringBuilder infoNormalDeal = new StringBuilder();
    private int countGoodDeal = 0;
    private int countNormalDeal = 0;
    private BigDecimal novValue = null;
    private BigDecimal MAXValue = null;
    private BigDecimal MINValue = null;
    private BigDecimal result = null;

    public static StringBuilder getInfoGoodDeal() {
        return infoGoodDeal;
    }

    public static StringBuilder getInfoNormalDeal() {
        return infoNormalDeal;
    }

    public int getCountGoodDeal() {
        return countGoodDeal;
    }

    public int getCountNormalDeal() {
        return countNormalDeal;
    }

    public static String getStringBuilder() {
        return stringBuilder;
    }

    private BigDecimal percent (String s) {
        result = MAXValue.subtract(MINValue);
        BigDecimal percent = result.multiply(new BigDecimal(s)).add(MINValue);
        return percent;
    }

    public void calculateAverageValues(Stock stock) {

        StringBuilder sb = new StringBuilder(stock.getName()).append("\n");
        String companyName = stock.getName();

        novValue = new BigDecimal(stock.getNowValue());
        MAXValue = new BigDecimal(stock.getMaxValue());
        MINValue = new BigDecimal(stock.getMinValue());

        BigDecimal halfResult = percent("0.5");
        BigDecimal quarterResult = percent("0.25");
        BigDecimal threeEighthsResult = percent("0.375");

        String stringNowValue = "--> Nov   = " + novValue;
        String stringMAXValue = "52 w High = " + MAXValue;
        String stringMINValue = "52 w Low  = " + MINValue;
        String fiftyPercent = "50%       = " + halfResult;
        String twentyFivePercent = "25%       = " + quarterResult;
        String threeEighthsPercent = "37.5%     = " + threeEighthsResult;

        System.out.println();
        sb.append(stringMAXValue).append("\n");
        if (novValue.compareTo(halfResult) >= 0) {
            sb.append(stringNowValue + " не выгодная сделка").append("\n");
        }
        sb.append(fiftyPercent).append("\n");
        if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(quarterResult) >= 0) {
            if (novValue.compareTo(threeEighthsResult) > 0) {
                sb.append(stringNowValue + " не очень выгодная сделка").append("\n");
                sb.append(threeEighthsPercent).append("\n");
            } else {
                sb.append(threeEighthsPercent).append("\n");
                sb.append(stringNowValue + " нормальная сделка").append("\n");
            }
            infoNormalDeal.append(companyName + " ");
            countNormalDeal++;
        }
        sb.append(twentyFivePercent).append("\n");
        if (novValue.compareTo(quarterResult) < 0) {
            sb.append(stringNowValue + " очень выгодная сделка").append("\n");
            infoGoodDeal.append(companyName + " ");
            countGoodDeal++;
        }
        sb.append(stringMINValue).append("\n\n");
        stringBuilder = sb.toString();
        System.out.println(stringBuilder);
    }

}
