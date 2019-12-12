package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class NonExemptProductTest {
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                BigDecimal.valueOf(18.99), 
                1);
        
        assertEquals(perfume.tax(), 
                BigDecimal.valueOf(1.90)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(perfume.price(), 
                BigDecimal.valueOf(20.89)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NonExemptProduct("book",
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
    public void givenNonExemptProductWhenThereIsMoreThanOneItemThenReturnsExpectedValue() {
        Product cd = new NonExemptProduct("cd", 
                BigDecimal.valueOf(14.99), 
                10);
        
        assertEquals(cd.tax(), 
                BigDecimal.valueOf(15.00)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(cd.price(), 
                BigDecimal.valueOf(164.90)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
