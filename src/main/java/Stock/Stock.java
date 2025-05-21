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

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getNowValue() {
        return nowValue;
    }

    public Stock setNowValue(BigDecimal nowValue) {
        this.nowValue = nowValue;
        return this;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public Stock setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public Stock setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
        return this;
    }

    public Stock(String name, BigDecimal nowValue, BigDecimal maxValue, BigDecimal minValue) {
        this.name = name;
        this.nowValue = nowValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
