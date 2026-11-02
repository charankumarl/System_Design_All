package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable.Amazon_Products;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable.Iphone14;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observable.Iphone15;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.EmailNotification;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.Notify_All;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o2_Observer.Observer.SmsNotification;

public class Main {

    public static void main(String[] args) {

        Amazon_Products iphone15 = new Iphone15("Iphone 15");

        Notify_All cust1 = new EmailNotification("charan@gmail.com", iphone15, "Iphone 15");
        Notify_All cust2 = new EmailNotification("charan1@gmail.com", iphone15, "Iphone 15");
        Notify_All cust3 = new SmsNotification("1234", iphone15, "Iphone 15");

        iphone15.add(cust1);
        iphone15.add(cust2);
        iphone15.add(cust3);

        iphone15.setData(5);
        iphone15.setData(0);

        Amazon_Products iphone14 = new Iphone14("Iphone 14");

        Notify_All c1 = new EmailNotification("charan@gmail.com", iphone14, "Iphone 14");
        Notify_All c2 = new EmailNotification("charan1@gmail.com", iphone14, "Iphone 14");
        Notify_All c3 = new SmsNotification("1234", iphone14, "Iphone 14");

        iphone14.add(c1);
        iphone14.add(c2);
        iphone14.add(c3);

        iphone14.setData(5);
    }
}
