package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImportedProductTest {
    @Test
    public void givenExemptAndImportedProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        Product chocolate = new ExemptProduct("box of chocolate", 
                new Decimal(10.00), 
                1);
        
        Product imported = new ImportedProduct(chocolate);
        assertEquals(imported.tax().getDouble(), 0.50, 0.001);
        assertEquals(imported.price().getDouble(), 10.50, 0.001);
    }
    
    @Test
    public void givenExemptAndImportedProductWhenThereIsNoValueThenReturnsZero() {
        Product perfume = new ExemptProduct("imported bottle of perfume", 
                new Decimal(0),
                1);
        
        Product imported = new ImportedProduct(perfume);
        assertEquals(imported.tax().getDouble(), 0.0, 0.001);
        assertEquals(imported.price().getDouble(), 0.0, 0.001);
    }
    
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsNoValueThenReturnsZero() {
        Product book = new NonExemptProduct("book", 
                new Decimal(0),
                1);
        
        Product imported = new ImportedProduct(book);
        assertEquals(imported.tax().getDouble(), 0.0, 0.001);
        assertEquals(imported.price().getDouble(), 0.0, 0.001);
    }
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsMoreThanOneThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                new Decimal(47.50), 
                10);
        
        Product imported = new ImportedProduct(perfume);
        assertEquals(imported.tax().getDouble(), 71.50, 0.001);
        assertEquals(imported.price().getDouble(), 546.50, 0.001);
    }
    
    @Test
    public void givenNonExemptAndImportedProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("perfume", 
                new Decimal(47.50), 
                1);
        
        Product imported = new ImportedProduct(perfume);
        
        assertEquals(imported.tax().getDouble(), 7.15, 0.001);
        assertEquals(imported.price().getDouble(), 54.65, 0.001);
    }
    
    
    @Test
    public void givenAnotherNonExemptAndImportedProductWhenThereIsValueThenReturnsExpectedValue() {
        Product perfume = new NonExemptProduct("imported bottle of perfume", 
                new Decimal(27.99),
                1);
        
        Product imported = new ImportedProduct(perfume);
        
        assertEquals(imported.tax().getDouble(), 4.20, 0.001);
        assertEquals(imported.price().getDouble(), 32.19, 0.001);
    }

}
