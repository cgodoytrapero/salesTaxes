package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExemptProductTest {
    
    @Test
    public void givenExemptProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product book = new ExemptProduct("book", 
                new Decimal(12.49), 
                1);
        assertEquals(book.tax().getDouble(), 0.0, 0.001);
        assertEquals(book.price().getDouble(), 12.49, 0.001);
    }

    @Test
    public void givenExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new ExemptProduct("book",
                new Decimal(0), 
                1);
        assertEquals(book.tax().getDouble(), 0.0, 0.001);
        assertEquals(book.price().getDouble(), 0.0, 0.001);
    }
    
    @Test
    public void givenExemptProductWhenThereIsMoreThanOneItemThenReturnsExpectedValue() {
        Product book = new ExemptProduct("book", 
                new Decimal(12.49),
                10);
        
        assertEquals(book.tax().getDouble(), 0.0, 0.001);
        assertEquals(book.price().getDouble(), 124.90, 0.001);
    }
}
