package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o2_Composite_Pattern.Without_Composite;

public class File {

    String name;

    public File(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("File: " + name);
    }
}
