package lastminute.taxSales;

public class ImportedProduct extends Product{
    private static final double RATE = 0.05;
    
    public ImportedProduct(Product product) {
        super(product.getName(),
                product.getValue(), 
                product.getItems());
        Decimal charges = this.getCharges();
        Decimal rate = new Decimal(RATE);
        charges.add(rate);
        charges.add(product.getCharges());
        this.setCharges(charges);
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
