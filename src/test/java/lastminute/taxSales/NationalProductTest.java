package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class NationalProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new NationalProduct("book", 12.49, true);
        assertEquals(book.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(12.49));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product book = new NationalProduct("book", 12.49, false);
        assertEquals(book.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(13.74));
        assertEquals(book.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(1.25));
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