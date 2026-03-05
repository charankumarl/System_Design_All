package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o8_Iterator.Implementation_Of_Iterator;

import java.util.ArrayList;
import java.util.List;

public class Book_Collection implements Collections{

    List<Books> booksList;

    public Book_Collection(){
        booksList = new ArrayList<>();
    }

    public void add(Books book){
        booksList.add(book);
    }

    @Override
    public Iterator createIterator() {

        return new Book_Iterator(booksList);
    }
}
