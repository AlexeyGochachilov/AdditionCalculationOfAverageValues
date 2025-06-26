package Stock;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Stock {

    /**
     * This class represents a stock with its name, current value, maximum value, and minimum value.
     * It provides methods to access these properties.
     */
    private final String name;
    private final BigDecimal nowValue;
    private final BigDecimal maxValue;
    private final BigDecimal minValue;


}
