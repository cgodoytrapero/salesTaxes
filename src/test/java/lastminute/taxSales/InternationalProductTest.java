package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class InternationalProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product chocolate = new InternationalProduct("box of chocolate", 10.00, true);
        assertEquals(chocolate.getTax(), 
                BigDecimal.valueOf(0.50)
                    .setScale(2, BigDecimal.ROUND_UP));
        assertEquals(chocolate.getPrice(), 
                BigDecimal.valueOf(10.50)
                    .setScale(2, BigDecimal.ROUND_UP));
    }
    
    @Test
    public void givenAnotherExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product perfume = new InternationalProduct("imported bottle of perfume", 27.99, false);
        assertEquals(perfume.getTax(), 
                BigDecimal.valueOf(4.20)
                    .setScale(2, BigDecimal.ROUND_UP));
        assertEquals(perfume.getPrice(), 
                BigDecimal.valueOf(32.19)
                    .setScale(2, BigDecimal.ROUND_UP));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new InternationalProduct("perfume", 47.50, false);
        assertEquals(perfume.getTax(), 
                BigDecimal.valueOf(7.15)
                    .setScale(2, BigDecimal.ROUND_UP));
        assertEquals(perfume.getPrice(), 
                BigDecimal.valueOf(54.65)
                    .setScale(2, BigDecimal.ROUND_UP));  
       
    }
    
    @Test
    public void givenExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("box of chocolate", 0, true);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("book", 0, false);
        assertEquals(book.getPrice().setScale(0, BigDecimal.ROUND_UP), 
                BigDecimal.valueOf(0));
        assertEquals(book.getTax().setScale(0, BigDecimal.ROUND_UP), 
                BigDecimal.valueOf(0));
    }
}