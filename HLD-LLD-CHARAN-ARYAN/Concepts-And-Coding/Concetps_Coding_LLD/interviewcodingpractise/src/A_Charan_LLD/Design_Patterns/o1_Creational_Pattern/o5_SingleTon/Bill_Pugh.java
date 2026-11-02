package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o5_SingleTon;

public class Bill_Pugh {

    private Bill_Pugh() {

    }

    private static class SingletonHelper {

        private static final Bill_Pugh INSTANCE = new Bill_Pugh();
    }

    public static Bill_Pugh getInstance() {

        return SingletonHelper.INSTANCE;
    }
}
