package lastminute.taxSales;

import java.math.BigDecimal;

public class Decimal {
    private BigDecimal value;
    
    public Decimal(double value) {
        this.value = new BigDecimal(value);
    }
    
    public Decimal(int value) {
        this.value = new BigDecimal(value);
    }
    
//    public Decimal(Decimal other) {
//        this.value = other.getValue();
//    }
//    
//    public Decimal() {
//        this.value = new BigDecimal(0);
//    }
    
    public BigDecimal getValue() {
        return this.value;
    }
    
    public double getDouble() {
        return this.value.doubleValue();
    }
    
    public int getInt() {
        return this.value.intValue();
    }
    
    public void round () {
        this.value = this.value.multiply(BigDecimal.valueOf(20.0))
            .setScale(0, BigDecimal.ROUND_UP)
            .divide(BigDecimal.valueOf(20.0))
            .setScale(2, BigDecimal.ROUND_UP);
    }
    
    public void multiply(Decimal other) {
        this.value = this.value.multiply(other.getValue());
        this.value = this.value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public void add(Decimal other) {
        this.value = this.value.add(other.getValue());
    }

}
