package lastminute.taxSales;

import java.math.BigDecimal;

public class ExemptProduct extends Product {
    private static final double RATE = 0.0;
    
    public ExemptProduct(String name,
            BigDecimal value,
            int items) {
        super(name, value, items);
        this.setCharges(new BigDecimal(RATE));
    }

    @Override
    public BigDecimal getTax() {
        return this.round(this.getValue()
                .multiply(this.getCharges()
                .setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    
}
