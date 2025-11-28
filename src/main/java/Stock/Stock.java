package Stock;

import lombok.Data;

import java.math.BigDecimal;

import static CalculateAPP.CalculateIMPL.nowPercent;

@Data
public class Stock {

    /**
     * This class represents a stock with its name, current value, maximum value, and minimum value.
     * It provides methods to access these properties.
     */
    private final String name;
    private final BigDecimal nowValue;
    private final BigDecimal maxValue;
    private final BigDecimal minValue;
    private BigDecimal PE;
    private BigDecimal EPS;
    private BigDecimal epsFrom5Years;
    private BigDecimal grahamPrice;

    public Stock(String name, BigDecimal nowValue, BigDecimal maxValue, BigDecimal minValue) {
        this.name = name;
        this.nowValue = nowValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public String toString() {
        if (grahamPrice == null) {
            return name + "\n"
                    + "52 w High = " + maxValue + "\n"
                    + "--> Nov   = " + nowValue + " (" + nowPercent(this) + "%)" + "\n"
                    + "minValue = " + minValue + "\n";
        } else  return name + "\n"
                + "52 w High = " + maxValue + "\n"
                + "--> Nov   = " + nowValue + " (" + nowPercent(this) + "%)" + "\n"
                + "grahamPrice = " + grahamPrice + "\n"
                + "minValue = " + minValue + "\n";

    }

}
