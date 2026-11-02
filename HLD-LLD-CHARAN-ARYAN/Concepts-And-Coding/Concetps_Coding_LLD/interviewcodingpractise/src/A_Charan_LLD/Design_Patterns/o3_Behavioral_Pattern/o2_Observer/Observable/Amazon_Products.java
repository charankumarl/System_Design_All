package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.Notify_All;

public interface Amazon_Products {

    void add(Notify_All observer);
    void remove(Notify_All observer);

    void notify_all();

    void setData(int data);
    int getData();
}
