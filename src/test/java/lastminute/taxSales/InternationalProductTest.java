package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class InternationalProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new InternationalProduct("book", 12.49, true);
        assertEquals(book.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(13.11));
        assertEquals(book.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0.62));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product book = new InternationalProduct("book", 12.49, false);
        assertEquals(book.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(14.36));
        assertEquals(book.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(1.87));
    }
    
    @Test
    public void givenExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("book", 0, true);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("book", 0, false);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
}