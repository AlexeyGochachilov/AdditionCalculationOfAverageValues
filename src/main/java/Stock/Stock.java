package Stock;

public class Stock {

    private String name;
    private String nowValue;
    private String maxValue;
    private String minValue;

    public String getName() {
        return name;
    }

    public Stock setName(String name) {
        this.name = name;
        return this;
    }

    public String getNowValue() {
        return nowValue;
    }

    public Stock setNowValue(String nowValue) {
        this.nowValue = nowValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public Stock setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public Stock setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public Stock(String name, String nowValue, String maxValue, String minValue) {
        this.name = name;
        this.nowValue = nowValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}
