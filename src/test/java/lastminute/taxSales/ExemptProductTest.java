package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ExemptProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new ExemptProduct("book", 
                BigDecimal.valueOf(12.49), 
                1);
        
        assertEquals(book.price(), 
                BigDecimal.valueOf(12.49)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(book.tax(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void givenExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new ExemptProduct("book",
                BigDecimal.valueOf(0), 
                1);
        
        assertEquals(book.price(), 
                BigDecimal.valueOf(0)
                .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(book.tax(), 
                BigDecimal.valueOf(0)
                .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenExemptProductWhenThereIsMoreThanOneItemThenReturnsExpectedValue() {
        Product book = new ExemptProduct("book", 
                BigDecimal.valueOf(12.49),
                10);
        
        assertEquals(book.tax(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(book.price(), 
                BigDecimal.valueOf(124.90)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));

    }
}
