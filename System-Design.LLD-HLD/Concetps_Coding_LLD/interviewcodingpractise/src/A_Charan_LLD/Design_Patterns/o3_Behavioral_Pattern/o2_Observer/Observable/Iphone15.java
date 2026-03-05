package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.Notify_All;

import java.util.*;

public class Iphone15 implements Amazon_Products{

    private List<Notify_All> observerList = new ArrayList<>();

    int availableStocks = 0;
    String productName;

    public Iphone15(String productName){
        this.productName = productName;
    }

    public void add(Notify_All observer){
        observerList.add(observer);
    }

    public void remove(Notify_All observer){
        observerList.remove(observer);
    }

    public void notify_all(){

        for(Notify_All observer: observerList){
            observer.update();
        }
    }

    public void setData(int availableStocks){
        this.availableStocks += availableStocks;

        if(availableStocks > 0) notify_all();
    }

    public int getData(){
        return availableStocks;
    }
}
