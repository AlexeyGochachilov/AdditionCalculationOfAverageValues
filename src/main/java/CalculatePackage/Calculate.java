package CalculatePackage;

import java.math.BigDecimal;

public class Calculate {

    private static String stringBuilder;
    private static StringBuilder infoGoodDeal = new StringBuilder();
    private static StringBuilder infoNormalDeal = new StringBuilder();
    private int countGoodDeal = 0;
    private int countNormalDeal = 0;

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

    public void calculateAverageValues(String info) {

        String[] infos = info.trim().split(", ");
        String[] values = infos[1].split("; ");
        StringBuilder sb = new StringBuilder(infos[0]).append("\n");
        String companyName = infos[0];

        BigDecimal novValue = new BigDecimal(values[0]);
        BigDecimal MAXValue = new BigDecimal(values[1]);
        BigDecimal MINValue = new BigDecimal(values[2]);
        BigDecimal result = MAXValue.subtract(MINValue);
        BigDecimal halfResult = result.divide(new BigDecimal(2)).add(MINValue);
        BigDecimal quarterResult = result.divide(new BigDecimal(4)).add(MINValue);
        BigDecimal threeEighthsResult = result.multiply(new BigDecimal("0.375")).add(MINValue);

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
