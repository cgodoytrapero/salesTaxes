package lastminute.taxSales;

import java.math.BigDecimal;

public interface Product {
    String getName();
    BigDecimal getPrice();
    BigDecimal getTax();
}
