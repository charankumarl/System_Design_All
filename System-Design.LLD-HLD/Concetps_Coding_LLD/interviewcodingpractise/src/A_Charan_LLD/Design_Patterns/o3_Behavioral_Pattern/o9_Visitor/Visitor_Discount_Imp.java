package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor;

public class Visitor_Discount_Imp implements Visitor_Discount {

    double totalPrice = 0;

    @Override
    public void discount(Book book) {

        double price = book.getPrice();
        double discount = price * 0.10;  // 10% discount

        totalPrice += price - discount;
    }

    @Override
    public void discount(Electronics electronics) {  // discount cah be changed or add new discount logic

        double price = electronics.getPrice();
        double discount = price * 0.20;  // 20% discount

        totalPrice += price - discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
