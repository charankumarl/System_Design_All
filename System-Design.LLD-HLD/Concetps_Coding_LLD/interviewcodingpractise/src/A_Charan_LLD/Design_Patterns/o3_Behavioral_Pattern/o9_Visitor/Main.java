package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor;

public class Main {

    public static void main(String[] args) {

        Items items[] = {
                new Book("book1", 20.0),
                new Book("book2", 30.0),

                new Electronics("elec1", 150.0),
        };

        Visitor_Discount_Imp discount = new Visitor_Discount_Imp();

        for(Items item : items) {
            item.accept(discount);
        }

        System.out.println(discount.getTotalPrice());
    }
}
