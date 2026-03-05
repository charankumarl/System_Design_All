package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o5_Facade;

public class Emp_Facade {

    Emp_DAO emp_dao;

    Emp_Facade(Emp_DAO emp_dao){
        this.emp_dao = emp_dao;
    }

    public void insert(){
        emp_dao.insert();
    }

    /*
        Exposed only insert method to client

        Hided the remaining methods from client. Delete and Update.

        Facade is used to hide the complexity of the system and provide an interface to the client using which the
         client can access the system.

        We hide the some parts of the system from the client and expose only the required part to the client.
     */
}
