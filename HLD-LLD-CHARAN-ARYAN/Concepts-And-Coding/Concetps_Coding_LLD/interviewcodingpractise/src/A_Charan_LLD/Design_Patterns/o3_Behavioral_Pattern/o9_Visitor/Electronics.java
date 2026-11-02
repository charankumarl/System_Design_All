package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor;

public class Electronics implements Items {

    private String brand;
    private double price;

    public Electronics(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(Visitor_Discount visitor) {

        visitor.discount(this);
    }
}
