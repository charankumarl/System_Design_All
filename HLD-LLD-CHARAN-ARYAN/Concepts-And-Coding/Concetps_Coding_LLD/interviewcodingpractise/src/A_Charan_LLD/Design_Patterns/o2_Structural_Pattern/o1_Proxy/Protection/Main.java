package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o1_Proxy.Protection;

import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) {

        DataBase userDB = new Proxy_RDBMS("user");
        userDB.access();

        DataBase adminDB = new Proxy_RDBMS("user");
        adminDB.access();
    }
}
