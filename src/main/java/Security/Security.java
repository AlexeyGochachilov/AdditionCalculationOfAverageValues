package Security;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class Security {

    private String name;
    private BigDecimal nowValue;
    private BigDecimal maxValue;
    private BigDecimal minValue;

    public Security(String name, BigDecimal nowValue, BigDecimal maxValue, BigDecimal minValue) {
        this.name = name;
        this.nowValue = nowValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
