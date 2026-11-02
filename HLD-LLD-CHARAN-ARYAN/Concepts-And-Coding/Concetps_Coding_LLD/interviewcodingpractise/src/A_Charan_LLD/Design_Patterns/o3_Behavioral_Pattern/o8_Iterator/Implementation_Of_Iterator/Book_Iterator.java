package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o8_Iterator.Implementation_Of_Iterator;

import java.util.List;

public class Book_Iterator implements Iterator{

    List<Books> booksList;
    int index = 0;

    Book_Iterator(List<Books> booksList){
        this.booksList = booksList;
    }

    @Override
    public boolean hasNext() {

        if(index < booksList.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {

        if(hasNext()){
            return booksList.get(index++);
        }
        return null;
    }
}
