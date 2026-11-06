package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o8_Object_Pooling;

public class DBConnection {

    private String id;

    DBConnection(String id) {
        this.id = id;
    }
    void connect() {

        System.out.println(id + " connected, running query...");
    }
}
