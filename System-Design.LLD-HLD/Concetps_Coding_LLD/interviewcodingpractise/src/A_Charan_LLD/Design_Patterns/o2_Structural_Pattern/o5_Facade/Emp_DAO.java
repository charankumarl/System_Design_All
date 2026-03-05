package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o5_Facade;

public class Emp_DAO implements DAO{

    public void update() {
        System.out.println("Updating Employee");
    }

    public void delete() {
        System.out.println("Deleting Employee");
    }

    public void insert() {
        System.out.println("Inserting Employee");
    }
}
