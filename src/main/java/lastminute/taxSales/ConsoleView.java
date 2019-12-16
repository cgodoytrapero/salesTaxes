package lastminute.taxSales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleView implements View {
    
    private BufferedReader bufferedReader = 
            new BufferedReader(new InputStreamReader(System.in));
    
    private void write(String string) {
        System.out.print(string);
    }

    private void writeln(String string) {
        System.out.println(string);
    }

    private void writeError(String format) {
        System.out.println("Format error, please introduce the format " + format);
    }
    
    private String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError("It must be string");
            }
        } while (!ok);
        return input;
    }

    private int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("It must be integer");
            }
        } while (!ok);
        return input;
    }
    
    private double readDouble(String title) {
        double input = 0;
        boolean ok = false;
        do {
            try {
                input = Double.parseDouble(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("It must be double");
            }
        } while (!ok);
        return input;
    }
    
    
    private boolean readBoolean(String title) {
        boolean input = false;
        boolean ok = false;
        do {
            try {
                input = Boolean.parseBoolean(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("It must be boolean");
            }
        } while (!ok);
        return input;
    }
    

    @Override
    public String getName() {
        return this.readString("Introduce the name of the product");
    }

    @Override
    public double getPrice() {
        return this.readDouble("Introduce the price of the product");
    }

    @Override
    public int getItems() {
        return this.readInt("Introduce the items of the product");
    }

    @Override
    public boolean getExempt() {
        return this.readBoolean("Introduce if the product is exempt");
    }

    @Override
    public boolean getImported() {
        return this.readBoolean("Introduce if the product is imported");
    }

    @Override
    public boolean isNext() {
        return this.readBoolean("Introduce if you want to add more products to the cart");
    }

    @Override
    public void printProduct(String name, String title) {
        this.writeln(name + " : "
                + title
                + " €");    }

    @Override
    public void printTaxes(String title) {
        this.writeln("Taxes : "
                + title
                + " €");
    }

    @Override
    public void printPrice(String title) {
        this.writeln("Price : "
                + title
                + " €");
    }


}
