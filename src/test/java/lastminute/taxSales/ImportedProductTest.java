package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ImportedProductTest {
    @Test
    public void givenExemptAndImportedProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product chocolate = new ExemptProduct("box of chocolate", 
                BigDecimal.valueOf(10.00), 
                1);
        
        Product imported = new ImportedProduct(chocolate);
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(0.50)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.price(), 
                BigDecimal.valueOf(10.50)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenExemptAndImportedProductWhenThereIsNoValueThenReturnsZero() {
        Product perfume = new ExemptProduct("imported bottle of perfume", 
                BigDecimal.valueOf(0),
                1);
        
        Product imported = new ImportedProduct(perfume);
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.price(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NonExemptProduct("book", 
                BigDecimal.valueOf(0),
                1);
        
        Product imported = new ImportedProduct(book);
        assertEquals(imported.price(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(0)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsMoreThanOneThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                BigDecimal.valueOf(47.50), 
                10);
        
        Product imported = new ImportedProduct(perfume);
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(71.50)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.price(), 
                BigDecimal.valueOf(546.50)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                BigDecimal.valueOf(47.50), 
                1);
        
        Product imported = new ImportedProduct(perfume);
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(7.15)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.price(), 
                BigDecimal.valueOf(54.65)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }
    
    
    @Test
    public void givenAnotherNonExemptAndImportedProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("imported bottle of perfume", 
                BigDecimal.valueOf(27.99),
                1);
        
        Product imported = new ImportedProduct(perfume);
        
        assertEquals(imported.tax(), 
                BigDecimal.valueOf(4.20)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(imported.price(), 
                BigDecimal.valueOf(32.19)
                    .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
