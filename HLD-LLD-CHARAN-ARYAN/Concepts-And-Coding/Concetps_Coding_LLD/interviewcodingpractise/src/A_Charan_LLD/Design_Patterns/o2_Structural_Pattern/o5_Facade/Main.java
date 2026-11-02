package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o5_Facade;

public class Main {

    public static void main(String[] args) {

        Emp_Facade emp = new Emp_Facade(new Emp_DAO());
        emp.insert();
    }
}
