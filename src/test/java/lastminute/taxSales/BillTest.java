package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BillTest {
    
    @Test
    public void givenInput1WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product book = new ExemptProduct("book", 
                new Decimal(12.49),
                1);
        Product cd = new NonExemptProduct("music CD", 
                new Decimal(14.99), 
                1);
        Product chocolate = new ExemptProduct("chocolate bar", 
                new Decimal(0.85), 
                1);

        Bill bill = new Bill();
        bill.add(book);
        bill.add(cd);
        bill.add(chocolate);
        
        assertEquals(bill.tax().getDouble(), 1.50, 0.001);
        assertEquals(bill.price().getDouble(), 29.83, 0.001);
    }
    
    @Test
    public void givenInput2WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product chocolate = new ExemptProduct("imported box of chocolates", 
                new Decimal(10.00),
                1);
        ImportedProduct importedChocolate = new ImportedProduct(chocolate);
        
        Product perfume = new NonExemptProduct("imported bottle of perfume", 
                new Decimal(47.50), 
                1);
        ImportedProduct importedPerfume = new ImportedProduct(perfume);
        
        Bill bill = new Bill();
        bill.add(importedChocolate);
        bill.add(importedPerfume);
        
        assertEquals(bill.tax().getDouble(), 7.65, 0.001);
        assertEquals(bill.price().getDouble(), 65.15, 0.001);
    }
    
    @Test
    public void givenInput3WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product bottle_perfume = new NonExemptProduct("imported bottle of perfume", 
                new Decimal(27.99), 
                1);
        ImportedProduct importedPerfume = new ImportedProduct(bottle_perfume);
        
        Product perfume = new NonExemptProduct("bottle of perfume", 
                new Decimal(18.99), 
                1);
        
        Product pills = new ExemptProduct("packet of headache pills", 
                new Decimal(9.75), 
                1);
        
        Product chocolate = new ExemptProduct("imported box of chocolate", 
                new Decimal(11.25), 
                1);
        ImportedProduct importedChocolate = new ImportedProduct(chocolate);
        
        Bill bill = new Bill();
        bill.add(importedPerfume);
        bill.add(perfume);
        bill.add(pills);
        bill.add(importedChocolate);
        
        assertEquals(bill.tax().getDouble(), 6.70, 0.001);
        assertEquals(bill.price().getDouble(), 74.68, 0.001);
    }
}
