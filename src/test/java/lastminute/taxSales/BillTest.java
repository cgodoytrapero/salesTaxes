package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BillTest {
    
    @Test
    public void givenInput1WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product book = new NationalProduct("book", 12.49, true);
        Item bookItem = new Item(book, 1);
        Product cd = new NationalProduct("music CD", 14.99, false);
        Item cdItem = new Item(cd, 1); 
        Product chocolate = new NationalProduct("chocolate bar", 0.85, true);
        Item chocolateItem = new Item(chocolate, 1);

        Bill bill = new Bill();
        bill.add(bookItem);
        bill.add(cdItem);
        bill.add(chocolateItem);
        
        assertEquals(bill.getTax(), 
                BigDecimal.valueOf(1.50)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.getPrice(), 
                BigDecimal.valueOf(29.83)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    
    @Test
    public void givenInput2WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product chocolate = new InternationalProduct("imported box of chocolates", 10.00, true);
        Item chocolateItem = new Item(chocolate, 1);
        
        Product perfume = new InternationalProduct("imported bottle of perfume", 47.50, false);
        Item perfumeItem = new Item(perfume, 1);
        
        Bill bill = new Bill();
        bill.add(chocolateItem);
        bill.add(perfumeItem);
        
        assertEquals(bill.getTax(), 
                BigDecimal.valueOf(7.65)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.getPrice(), 
                BigDecimal.valueOf(65.15)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
    
    @Test
    public void givenInput3WhenGetPriceAndTaxThenReturnsExpectedValue() {
        
        Product imported_perfume = new InternationalProduct("imported bottle of perfume", 27.99, false);
        Item perfumeImportedItem = new Item(imported_perfume, 1);
        
        Product perfume = new NationalProduct("bottle of perfume", 18.99, false);
        Item perfumeItem = new Item(perfume, 1);
        
        Product pills = new NationalProduct("packet of headache pills", 9.75, true);
        Item pillsItem = new Item(pills, 1);
        
        Product chocolate = new InternationalProduct("imported box of chocolate", 11.25, true);
        Item chocolateItem = new Item(chocolate, 1);
        
        Bill bill = new Bill();
        bill.add(perfumeImportedItem);
        bill.add(perfumeItem);
        bill.add(pillsItem);
        bill.add(chocolateItem);
        
        assertEquals(bill.getTax(), 
                BigDecimal.valueOf(6.70)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
        
        assertEquals(bill.getPrice(), 
                BigDecimal.valueOf(74.68)
                    .setScale(2, BigDecimal.ROUND_HALF_EVEN));
    }
}
