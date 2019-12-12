package lastminute.taxSales;

import java.math.BigDecimal;

public class ImportedProduct extends Product{
    private static final double RATE = 0.05;
    
    public ImportedProduct(Product product) {
        super(product.getName(),
                product.getValue(), 
                product.getItems());
        this.setCharges(new BigDecimal(RATE)
                .add(product.getCharges()));
    }

    @Override
    public BigDecimal getTax() {
        return this.round(this.getValue()
                .multiply(this.getCharges()
                .setScale(2, BigDecimal.ROUND_HALF_UP)));
    }
    

}
