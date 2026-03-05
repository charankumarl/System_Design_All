package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o5_SingleTon;

public class Main {

    public static void main(String[] args) {

        SingleTon singleTon = SingleTon.getInstance();
        singleTon.showMessage();

        //SingleTon singleTon1 = new SingleTon();  // cannot sine construictor is private

        Enum.INSTANCE.showMessage();
    }
}
