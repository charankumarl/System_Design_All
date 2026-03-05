package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o5_SingleTon;

public class SingleTon {

    private static SingleTon instance = null;  // Lazy.   Cannot use final because we are making as null, then cannnot change it.

    //  private static final Singleton INSTANCE = new Singleton();  Eager initialization

    private SingleTon(){
        System.out.println("SingleTon object created");
    }

    // To avoid reflection class to create new instance, we can throw excetion inside the constructor.
//    if (instance != null) {
//        throw new RuntimeException("Use getInstance() to create an object");
//    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static synchronized SingleTon getInstance(){

        if(instance == null){
            instance = new SingleTon();  // Lazy initialization
        }

        return instance;
    }

    int a;

    public void setA(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }

    /*
            Main

       a.setA(10);
     */
}
