package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.Notify_All;

import java.util.ArrayList;
import java.util.List;

public class Iphone14 implements Amazon_Products{

    private List<Notify_All> observerList = new ArrayList<>(); // this is all the observers. ex customer clicked notify for this product

    int availableStocks = 0;
    String productName;

    public Iphone14(String productName){
        this.productName = productName;
    }

    public void add(Notify_All observer){  // add means add to the list of observers
        observerList.add(observer);
    }

    public void remove(Notify_All observer){
        observerList.remove(observer);
    }

    public void notify_all(){

        for(Notify_All observer: observerList){  // when anything changes, we notify all the observers. traverse through all the observers
            observer.update();
        }
    }

    public void setData(int availableStocks){
        this.availableStocks += availableStocks;

        if(availableStocks > 0) notify_all();  // if we have stock, notify all the observers
    }

    public int getData(){
        return availableStocks;
    }
}
