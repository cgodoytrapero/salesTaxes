package lastminute.taxSales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecimalTest {
    @Test
    public void givenDecimalWhenMultiplyAndRoundThenReturnsExpectedValue() {
     
        Decimal decimal = new Decimal(14.99);
        Decimal other = new Decimal(0.1);
        decimal.multiply(other);
        decimal.round();
        
        assertEquals(decimal.getDouble(), 1.50, 0.001);
    }
    
    @Test
    public void givenDecimalWhenMultiplyAndRoundAndAddThenReturnsExpectedValue() {
     
        Decimal decimal = new Decimal(14.99);
        Decimal other = new Decimal(0.1);
        decimal.multiply(other);
        decimal.round();
        Decimal sum = new Decimal(14.99);
        sum.add(decimal);
        
        assertEquals(sum.getDouble(), 16.49, 0.001);
    }
    
    @Test
    public void givenDecimalWhenCopyConstructorThenReturnsExpectedValue() {
     
        Decimal decimal = new Decimal(14.99);
        Decimal other = decimal;
       
        assertEquals(other.getDouble(), 14.99, 0.001);
    }

}
