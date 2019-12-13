package lastminute.taxSales;

public class NonExemptProduct extends Product{
    private static final double RATE = 0.1;
    
    public NonExemptProduct(String name,
            Decimal value,
            int items) {
        super(name, value, items);
        this.setCharges(new Decimal(RATE));
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
