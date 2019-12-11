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
        return this.value
                .multiply(DUTY)
                .add(this.value
                        .multiply(this.basicTax));
    }
}
