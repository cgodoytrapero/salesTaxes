package lastminute.taxSales;

import java.math.BigDecimal;

public class NationalProduct implements Product {
    private String name; 
    private BigDecimal value;
    private BigDecimal basicTax;
        
    public NationalProduct(String name,
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
                .multiply(this.basicTax);
    }    
}
