package Security;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public class Stock extends Security {

    private BigDecimal PE;
    private BigDecimal EPS;
    private BigDecimal epsFrom5Years;
    @Setter
    private BigDecimal grahamPrice;
    private BigDecimal nowPercent;

    public Stock(String name, BigDecimal nowValue, BigDecimal maxValue, BigDecimal minValue) {
        super(name, nowValue, maxValue, minValue);
    }

    @Override
    public String toString() {
        if (grahamPrice == null) {
            return displayInfo;
        } else  return displayInfoWithGrahamPrice;
    }
    private final String displayInfo = super.getName() + "\n"
            + "52 w High = " + super.getMaxValue() + "\n"
            + "--> Nov   = " + super.getNowValue() + " (" + nowPercent + "%)" + "\n"
            + "minValue = " + super.getMinValue() + "\n";
    private final String displayInfoWithGrahamPrice = super.getName() + "\n"
            + "52 w High = " + super.getMaxValue() + "\n"
            + "--> Nov   = " + super.getNowValue() + " (" + nowPercent + "%)" + "\n"
            + "grahamPrice = " + grahamPrice + "\n"
            + "minValue = " + super.getMinValue() + "\n";

}
