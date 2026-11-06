package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o8_Object_Pooling;

import java.util.*;

public class ConnectionPool {

    private List<DBConnection> available = new ArrayList<>();
    private List<DBConnection> inUse = new ArrayList<>();

    ConnectionPool(int size) {

        for (int i = 1; i <= size; i++) {
            available.add(new DBConnection("Conn-" + i)); // created ONCE, upfront
        }
    }

    DBConnection getConnection() {

        if (available.isEmpty()) {
            throw new RuntimeException("No connections available");
        }
        DBConnection conn = available.removeLast();
        inUse.add(conn);
        return conn;
    }

    void releaseConnection(DBConnection conn) {

        inUse.remove(conn);
        available.add(conn); // back to pool, ready for reuse
    }
}
