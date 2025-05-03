package CalculatePackage;

import java.math.BigDecimal;

public class Calculate {

    private static String stringBuilder;

    public static String getStringBuilder() {
        return stringBuilder;
    }

    public static void calculateAverageValues(String info) {

        String[] infos = info.trim().split(", ");
        String[] values = infos[1].split("; ");
        StringBuilder sb = new StringBuilder(infos[0]).append("\n");

        BigDecimal novValue = new BigDecimal(values[0]);
        BigDecimal MAXValue = new BigDecimal(values[1]);
        BigDecimal MINValue = new BigDecimal(values[2]);
        BigDecimal result = MAXValue.subtract(MINValue);
        BigDecimal halfResult = result.divide(new BigDecimal(2)).add(MINValue);
        BigDecimal quarterResult = result.divide(new BigDecimal(4)).add(MINValue);

        String stringNowValue =    "--> Nov   = " + novValue;
        String stringMAXValue =    "52 w High = " + MAXValue;
        String stringMINValue =    "52 w Low  = " + MINValue;
        String fiftyPercent =      "50%       = " + halfResult;
        String twentyFivePercent = "25% =       " + quarterResult;

        System.out.println();
        sb.append(stringMAXValue).append("\n");
        if (novValue.compareTo(halfResult) >= 0) {
            sb.append(stringNowValue + " не выгодная сделка").append("\n");
        }
        sb.append(fiftyPercent).append("\n");
        if (novValue.compareTo(halfResult) < 0 && novValue.compareTo(quarterResult) >= 0) {
            sb.append(stringNowValue + " выгодная сделка").append("\n");
        }
        sb.append(twentyFivePercent).append("\n");
        if (novValue.compareTo(quarterResult) < 0) {
            sb.append(stringNowValue + " очень выгодная сделка").append("\n");
        }
        sb.append(stringMINValue).append("\n");
        stringBuilder = sb.toString();
        System.out.println(stringBuilder);
    }

}
