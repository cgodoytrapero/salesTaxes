package lastminute.taxSales;

public interface View {
    public String getName();
    public double getPrice();
    public int getItems();
    public boolean getExempt();
    public boolean getImported();
    public boolean isNext();
    public void printProduct(String name, String title);
    public void printTaxes(String title);
    public void printPrice(String title);
}
