package lastminute.taxSales;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private BigDecimal value;
    private int items;
    private BigDecimal charges;
    
    public Product (String name,
            BigDecimal value,
            int items) {
        this.name = name;
        this.value = value;
        this.items = items;
    }
    
    public String getName() {
        return this.name;
    }
    
    public BigDecimal getValue() {
        return value;
    }

    public int getItems() {
        return items;
    }
    
    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }
    
    public BigDecimal getCharges() {
        return this.charges;
    }
    
    public BigDecimal price() {
        return this.value.add(this.getTax())
                .multiply(BigDecimal.valueOf(items));
    }
    
    public BigDecimal tax() {
        return this.getTax()
                .multiply(BigDecimal.valueOf(items));
    }
    
    protected BigDecimal round (BigDecimal tax) {
        return tax.multiply(BigDecimal.valueOf(20.0))
            .setScale(0, BigDecimal.ROUND_UP)
            .divide(BigDecimal.valueOf(20.0))
            .setScale(2, BigDecimal.ROUND_UP);
    }
    
    protected abstract BigDecimal getTax();
}
