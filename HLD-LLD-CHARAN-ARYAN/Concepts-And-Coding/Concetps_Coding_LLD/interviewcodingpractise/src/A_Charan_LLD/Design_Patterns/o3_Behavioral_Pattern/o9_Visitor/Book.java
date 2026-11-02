package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o8_Iterator.Implementation_Of_Iterator.Iterator;

public class Book implements Items {

    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(Visitor_Discount visitor) {
        visitor.discount(this);
    }
    /*
        Discount will change frequently, so we can use visitor pattern to change the discount logic without changing the book class
        So, Book class can be closed for modification and open for extension
     */
}
