package lastminute.taxSales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> items = new ArrayList<Product>();
    
    public void add (Product item) {
        items.add(item);
    }
    
    public BigDecimal price() {
        BigDecimal price = new BigDecimal(0);
        for (Product it : items) {
            price = it.price().add(price);
        }
        return price;
    }
    
    public BigDecimal tax() {
        BigDecimal tax = new BigDecimal(0);
        for (Product it : items) {
            tax = it.tax().add(tax);
        }
        return tax;
    } 
}
