package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o1_Proxy.Protection;

public class Proxy_RDBMS implements DataBase{

    private DataBase dataBase;
    private String role;

    Proxy_RDBMS(String role){

        this.role = role;
    }

    public void access(){

        if(role.equals("admin")) {

            if(dataBase == null){
                dataBase = new RDBMS();
            }
            dataBase.access();
        }
        else{
            System.out.println("You are not authorized to access the database");
        }
    }
}
