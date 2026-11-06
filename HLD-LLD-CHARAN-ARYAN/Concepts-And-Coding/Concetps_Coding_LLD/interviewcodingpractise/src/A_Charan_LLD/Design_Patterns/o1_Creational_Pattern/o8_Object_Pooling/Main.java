package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o8_Object_Pooling;

public class Main {

    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool(2); // only 2 connections ever created

        DBConnection c1 = pool.getConnection();
        c1.connect(); // Conn-2 connected...

        DBConnection c2 = pool.getConnection();
        c2.connect(); // Conn-1 connected...

        pool.releaseConnection(c1); // Conn-2 back in pool

        DBConnection c3 = pool.getConnection(); // reuses Conn-2, no new object created
        c3.connect();
    }
}
