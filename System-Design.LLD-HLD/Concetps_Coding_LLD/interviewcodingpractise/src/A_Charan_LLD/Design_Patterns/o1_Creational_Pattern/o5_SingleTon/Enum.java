package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o5_SingleTon;

public enum Enum {

    INSTANCE;

    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }

    ///  In java Enum = singleton by default      Instance = new Enum();.

    ///  To give value follow this.

//    VALUES("value", 10);
//
//    String val;
//    int code;
//
//    Enum(String val, int code){
//        this.val = val;
//        this.code = code;
//    }

//    public int getCode() {
//        return code;
//    }
//    public String getMessage() {
//        return message;
//    }
}
