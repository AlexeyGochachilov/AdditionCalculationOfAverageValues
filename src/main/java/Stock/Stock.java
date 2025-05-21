package Stock;

import java.math.BigDecimal;

public class Stock {

    private String name;
    private BigDecimal nowValue;
    private BigDecimal maxValue;
    private BigDecimal minValue;

    public String getName() {
        return name;
    }

    public BigDecimal getNowValue() {
        return nowValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public Stock(String name, BigDecimal nowValue, BigDecimal maxValue, BigDecimal minValue) {
        this.name = name;
        this.nowValue = nowValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
