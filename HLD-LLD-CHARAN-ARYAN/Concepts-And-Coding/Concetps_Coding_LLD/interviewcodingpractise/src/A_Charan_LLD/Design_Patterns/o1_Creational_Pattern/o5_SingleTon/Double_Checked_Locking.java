package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o5_SingleTon;

public class Double_Checked_Locking {

    private static volatile Double_Checked_Locking instance;  //  volatile means , thread can get the latest value of the instance.

    private Double_Checked_Locking() {

    }

    public static Double_Checked_Locking getInstance() {

        if (instance == null) {   // we check for null twice before creating the instance.     Multiple threads will enter here

            synchronized (Double_Checked_Locking.class){   // but only 1 thread will enter and create the object

                if (instance == null) {  // remaining threads will create a new object.
                    instance = new Double_Checked_Locking();
                }
            }
        }
        return instance;
    }

}
