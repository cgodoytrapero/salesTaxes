package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BillTest {
    
//    @Test
//    public void given() {
//        
//        Product book = new NationalProduct("book", 1, true);
//        Item bookItem = new Item(book, 1);
//        Product cd = new NationalProduct("music CD", 2, true);
//        Item cdItem = new Item(cd, 1); 
//
//        Bill bill = new Bill();
//        bill.add(bookItem);
//        bill.add(cdItem);
//        
//        assertEquals(bill.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
//                BigDecimal.valueOf(3.00));
//        assertEquals(bill.getTax().setScale(2, BigDecimal.ROUND_HALF_UP), 
//                BigDecimal.valueOf(1.50));
//    }
    
    @Test
    public void givenExemptInternationalProductWhenThereIsValueGetPriceThenReturnsExpectedValue() {
        
        Product book = new NationalProduct("book", 12.49, true);
        Item bookItem = new Item(book, 1);
        Product cd = new NationalProduct("music CD", 14.99, false);
        Item cdItem = new Item(cd, 1); 
        Product chocolate = new NationalProduct("chocolate bar", 0.85, false);
        Item chocolateItem = new Item(chocolate, 1);

        Bill bill = new Bill();
        bill.add(bookItem);
        bill.add(cdItem);
        bill.add(chocolateItem);
        
//        assertEquals(bill.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP), 
//                BigDecimal.valueOf(29.83));
        assertEquals(bill.getTax().setScale(2, BigDecimal.ROUND_HALF_DOWN), 
                BigDecimal.valueOf(1.50));
    }
}
