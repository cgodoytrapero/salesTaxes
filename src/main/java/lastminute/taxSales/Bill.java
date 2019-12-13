package lastminute.taxSales;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> items = new ArrayList<Product>();
    
    public void add (Product item) {
        items.add(item);
    }
    
    public Decimal price() {
        Decimal price = new Decimal(0);
        for (Product it : items) {
            price.add(it.price());
        }
        return price;
    }
    
    public Decimal tax() {
        Decimal tax = new Decimal(0);
        for (Product it : items) {
            tax.add(it.tax());
        }
        return tax;
    } 
}
