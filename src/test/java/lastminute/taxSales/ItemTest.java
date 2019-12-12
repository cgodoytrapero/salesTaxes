package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {
    @Test
    public void givenExemptInternationalProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new InternationalProduct("chocolate", 11.25, true);
        Item item = new Item(book, 10);
       
        assertEquals(item.getTax(), 
                BigDecimal.valueOf(6.00)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(item.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(118.50)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenNonExemptInternationalProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new InternationalProduct("perfume", 47.50, false);
        Item item = new Item(perfume, 10);
        assertEquals(item.getTax(), 
                BigDecimal.valueOf(71.50)
                    .setScale(2, BigDecimal.ROUND_UP));
        assertEquals(item.getPrice(), 
                BigDecimal.valueOf(546.50)
                    .setScale(2, BigDecimal.ROUND_UP));
    }
    
    
    @Test
    public void givenExemptNationalProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new NationalProduct("book", 12.49, true);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(1, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(124.9));
        assertEquals(item.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptNationalProductWhenThereIsValueThenReturnsExpectedValue() {
        Product cd = new NationalProduct("cd", 14.99, false);
        Item item = new Item(cd, 10);
        
        assertEquals(item.getTax(), 
                BigDecimal.valueOf(15.00)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(item.getPrice(), 
                BigDecimal.valueOf(164.90)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenExemptInternationalProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("book", 0, true);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(item.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptInternationalProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new InternationalProduct("book", 0, false);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(item.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenExemptNationalProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NationalProduct("book", 0, true);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(item.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }
    
    @Test
    public void givenNonExemptNationalProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NationalProduct("book", 0, false);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
        assertEquals(item.getTax().setScale(0, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(0));
    }

}
