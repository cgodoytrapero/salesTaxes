package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BillTest {
    
    @Test
    public void givenInput1WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product book = new ExemptProduct("book", 
                BigDecimal.valueOf(12.49),
                1);
        Product cd = new NonExemptProduct("music CD", 
                BigDecimal.valueOf(14.99), 
                1);
        Product chocolate = new ExemptProduct("chocolate bar", 
                BigDecimal.valueOf(0.85), 
                1);

        Bill bill = new Bill();
        bill.add(book);
        bill.add(cd);
        bill.add(chocolate);
        
        assertEquals(bill.tax(), 
                BigDecimal.valueOf(1.50)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.price(), 
                BigDecimal.valueOf(29.83)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    
    @Test
    public void givenInput2WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product chocolate = new ExemptProduct("imported box of chocolates", 
                BigDecimal.valueOf(10.00),
                1);
        ImportedProduct importedChocolate = new ImportedProduct(chocolate);
        
        Product perfume = new NonExemptProduct("imported bottle of perfume", 
                BigDecimal.valueOf(47.50), 
                1);
        ImportedProduct importedPerfume = new ImportedProduct(perfume);
        
        Bill bill = new Bill();
        bill.add(importedChocolate);
        bill.add(importedPerfume);
        
        assertEquals(bill.tax(), 
                BigDecimal.valueOf(7.65)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.price(), 
                BigDecimal.valueOf(65.15)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    
    @Test
    public void givenInput3WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product bottle_perfume = new NonExemptProduct("imported bottle of perfume", 
                BigDecimal.valueOf(27.99), 
                1);
        ImportedProduct importedPerfume = new ImportedProduct(bottle_perfume);
        
        Product perfume = new NonExemptProduct("bottle of perfume", 
                BigDecimal.valueOf(18.99), 
                1);
        
        Product pills = new ExemptProduct("packet of headache pills", 
                BigDecimal.valueOf(9.75), 
                1);
        
        Product chocolate = new ExemptProduct("imported box of chocolate", 
                BigDecimal.valueOf(11.25), 
                1);
        ImportedProduct importedChocolate = new ImportedProduct(chocolate);

        
        Bill bill = new Bill();
        bill.add(importedPerfume);
        bill.add(perfume);
        bill.add(pills);
        bill.add(importedChocolate);
        
        assertEquals(bill.tax(), 
                BigDecimal.valueOf(6.70)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.price(), 
                BigDecimal.valueOf(74.68)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
}
