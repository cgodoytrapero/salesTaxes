package lastminute.taxSales;

import java.math.BigDecimal;

public class Item {
    private Product product;
    private int numberOfProducts;
    
    public Item (Product product,
            int number) {
        this.product = product;
        this.numberOfProducts = number;
    }
    
    public BigDecimal getPrice() {
        return this.product.getPrice()
                .multiply(BigDecimal.valueOf(numberOfProducts));
    }
    
    public BigDecimal getTax() {
        return this.product.getTax()
                .multiply(BigDecimal.valueOf(numberOfProducts));
    }
}
