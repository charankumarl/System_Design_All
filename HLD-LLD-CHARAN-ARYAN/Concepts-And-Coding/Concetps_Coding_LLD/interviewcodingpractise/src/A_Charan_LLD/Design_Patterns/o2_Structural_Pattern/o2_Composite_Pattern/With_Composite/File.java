package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o2_Composite_Pattern.With_Composite;

public class File implements File_System{

    private String name;

    public File(String name){
        this.name = name;
    }

    public void show(){
        System.out.println("File Name : "+name);
    }
}
