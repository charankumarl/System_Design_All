package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o8_Iterator.Implementation_Of_Iterator;

import java.awt.print.Book;

public class Main {

    public static void main(String[] args) {

        Book_Collection bookCollection = new Book_Collection();
        bookCollection.add(new Books("Book1", 10));
        bookCollection.add(new Books("Book2", 20));
        bookCollection.add(new Books("Book3", 30));
        bookCollection.add(new Books("Book4", 40));

        Iterator iterator = bookCollection.createIterator();

        while (iterator.hasNext()) {
            Books book = (Books) iterator.next();
            System.out.println("Book Name: " + book.name + " and Price: " + book.price);
        }
    }
}
