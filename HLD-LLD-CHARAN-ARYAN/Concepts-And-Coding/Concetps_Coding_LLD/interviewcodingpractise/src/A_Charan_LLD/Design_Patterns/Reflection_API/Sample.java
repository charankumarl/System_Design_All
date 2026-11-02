package A_Charan_LLD.Design_Patterns.Reflection_API;

public class Sample {

    private Sample(){
        System.out.println("Private Constructor");
    }

    private String name = "Charan";

    public void printName1(){
        System.out.println("Name is : " + name);
    }

    public void printName2(String name){
        System.out.println("Name is : " + name);
    }

}


