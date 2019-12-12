package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class NationalProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new NationalProduct("book", 12.49, true);
        assertEquals(book.getPrice(), 
                BigDecimal.valueOf(12.49)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(book.getTax(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NationalProduct("perfume", 18.99, false);
        assertEquals(perfume.getTax(), 
                BigDecimal.valueOf(1.90)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(perfume.getPrice(), 
                BigDecimal.valueOf(20.89)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NationalProduct("book", 0, true);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NationalProduct("book", 0, false);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
}