package lastminute.taxSales;

public abstract class Product {
    private String name;
    private Decimal value;
    private Decimal items;
    private Decimal charges;
    
    public Product (String name,
            Decimal value,
            int items) {
        this.name = name;
        this.value = value;
        this.items = new Decimal(items);
        this.charges = new Decimal(0);
    }
    
    public String getName() {
        return this.name;
    }
    
    public Decimal getValue() {
        return value;
    }

    public int getItems() {
        return items.getInt();
    }
    
    public void setCharges(Decimal charges) {
        this.charges = charges;
    }
    
    public Decimal getCharges() {
        return this.charges;
    }
    
    public Decimal price() {
        Decimal price = this.getTax();
        price.add(this.value);
        price.multiply(items);
        return price;
    }
    
    public Decimal tax() {
        Decimal taxes = this.getTax();
        taxes.multiply(this.items);
        return taxes;
    }
    
    protected abstract Decimal getTax();
}
