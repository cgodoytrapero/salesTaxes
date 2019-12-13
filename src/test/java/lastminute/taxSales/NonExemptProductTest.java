package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NonExemptProductTest {
    @Test
    public void givenNonExemptProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                new Decimal(18.99), 
                1);

        assertEquals(perfume.tax().getDouble(), 1.90, 0.001);
        assertEquals(perfume.price().getDouble(), 20.89, 0.001);
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NonExemptProduct("book",
                new Decimal(0), 
                1);
        
        assertEquals(book.tax().getDouble(), 0.0, 0.001);
        assertEquals(book.price().getDouble(), 0.0, 0.001);
    }
    
    @Test
    public void givenNonExemptProductWhenThereIsMoreThanOneItemThenReturnsExpectedValue() {
        Product cd = new NonExemptProduct("cd", 
                new Decimal(14.99), 
                10);
        
        assertEquals(cd.tax().getDouble(), 15.00, 0.001);
        assertEquals(cd.price().getDouble(), 164.90, 0.001);
    }

}
