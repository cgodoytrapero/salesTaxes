package lastminute.taxSales;

public class TaxSales {
    private View view;
    
    public TaxSales(View view) {
        this.view = view;
    }
    
    enum Type {
        NATIONAL_EXEMPT,
        NATIONAL_NON_EXEMPT,
        INTERNATIONAL_EXEMPT,
        INTERNATIONAL_NON_EXEMPT
    }
    
    private Type getType(boolean isExempt,
            boolean isImported) {
        Type type;
        if (isExempt && !isImported) {
            type = Type.NATIONAL_EXEMPT;
        } else if (!isExempt && !isImported) {
            type = Type.NATIONAL_NON_EXEMPT;
        } else if (isExempt && isImported) {
            type = Type.INTERNATIONAL_EXEMPT;
        } else if (!isExempt && isImported) {
            type = Type.INTERNATIONAL_NON_EXEMPT;
        } else {
            type = null;
        }
        return type;
    }
    
    
    public void run() {
        Bill bill = new Bill();
        do {
            String name = this.view.getName();
            double price = this.view.getPrice();
            int items = this.view.getItems();
            boolean isExempt = this.view.getExempt();
            boolean isImported = this.view.getImported();
            
            
            Product product = null;
            Product national = null;
            switch (this.getType(isExempt, isImported)) {
            case NATIONAL_EXEMPT:
                product = new ExemptProduct(name,
                        new Decimal(price),
                        items);
                break;
            case NATIONAL_NON_EXEMPT:
                product = new NonExemptProduct(name,
                        new Decimal(price),
                        items);
                break;
            case INTERNATIONAL_EXEMPT:
                national = new ExemptProduct(name,
                        new Decimal(price),
                        items);
                product = new ImportedProduct(national);
                break;
            case INTERNATIONAL_NON_EXEMPT:
                national = new ExemptProduct(name,
                        new Decimal(price),
                        items);
                product = new ImportedProduct(national);
                break;
            default:
                break;
            }
            
            bill.add(product);
        } while (this.view.isNext());
        
        for (Product it : bill.getItems()) {
            this.view.printProduct(it.getName(), 
                    it.price().toString());
        }
        this.view.printTaxes(bill.tax().toString());
        this.view.printPrice(bill.price().toString());
    }
    
    public static void main( String[] args ) {
        new TaxSales(new ConsoleView()).run();
    }
}
