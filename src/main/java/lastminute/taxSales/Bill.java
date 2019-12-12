package lastminute.taxSales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items = new ArrayList<Item>();
    
    public void add (Item item) {
        items.add(item);
    }
    
    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0);
        for (Item it : items) {
            price = it.getPrice().add(price);
        }
        return price;
    }
    
    public BigDecimal getTax() {
        BigDecimal tax = new BigDecimal(0);
        for (Item it : items) {
            tax = it.getTax().add(tax);
        }
        return tax;
    } 
    
    

}
