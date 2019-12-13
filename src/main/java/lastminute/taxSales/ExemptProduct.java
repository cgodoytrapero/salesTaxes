package lastminute.taxSales;

public class ExemptProduct extends Product {
    private static final double RATE = 0.0;
    
    public ExemptProduct(String name,
            Decimal value,
            int items) {
        super(name, value, items);
        Decimal rate = new Decimal(RATE);
        this.setCharges(rate);
    }

    @Override
    public Decimal getTax() {
        Decimal tax = new Decimal(0); 
        tax.add(this.getValue());
        tax.multiply(this.getCharges());
        tax.round();
        return tax;
    }

    
}
