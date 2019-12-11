package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ItemTest {
    @Test
    public void givenExemptInternationalProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new InternationalProduct("book", 12.49, true);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(131.15));
        assertEquals(item.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(6.25));
    }
    
    @Test
    public void givenNonExemptInternationalProductWhenThereIsValueThenReturnsExpectedValue() {
        Product book = new InternationalProduct("book", 12.49, false);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(143.64));
        assertEquals(item.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(18.74));
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
        Product book = new NationalProduct("book", 12.49, false);
        Item item = new Item(book, 10);
        assertEquals(item.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(137.39));
        assertEquals(item.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
                BigDecimal.valueOf(12.49));
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
