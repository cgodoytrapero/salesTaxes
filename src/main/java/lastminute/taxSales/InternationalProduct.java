package lastminute.taxSales;

import java.math.BigDecimal;

public class InternationalProduct implements Product {
    private String name; 
    private BigDecimal value;
    private BigDecimal basicTax;
    private static final BigDecimal DUTY = new BigDecimal(0.05);
    
    public InternationalProduct(String name,
            double value,
            boolean exempt){
        this.name = name;
        this.value = BigDecimal.valueOf(value);
        if (exempt == false) {
            this.basicTax = new BigDecimal(0.1);
        } else {
            this.basicTax = new BigDecimal(0);
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public BigDecimal getPrice() {
        return this.value
                .add(this.getTax());
    }
    
    public BigDecimal getTax() {
        BigDecimal percentage = InternationalProduct.DUTY
                .add(this.basicTax);
        
        return this.round(this.value
                .multiply(percentage)
                .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    
    private BigDecimal round (BigDecimal tax) {
        return tax.multiply(BigDecimal.valueOf(20.0))
            .setScale(0, BigDecimal.ROUND_UP)
            .divide(BigDecimal.valueOf(20.0))
            .setScale(2, BigDecimal.ROUND_UP);
    }
}
