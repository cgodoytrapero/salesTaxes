package lastminute.taxSales;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> items = new ArrayList<Product>();
    
    public void add (Product item) {
        items.add(item);
    }
    
    public List<Product> getItems() {
        return this.items;
    }
    
    public Decimal price() {
        Decimal price = items.stream()
                .map(p->p.price())
                .reduce(new Decimal(0), Decimal::accumulate);
        return price;
    }
    
    public Decimal tax() {
        Decimal tax = items.stream()
                .map(p->p.tax())
                .reduce(new Decimal(0), Decimal::accumulate);
        return tax;
    } 
}
