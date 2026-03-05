package InheritanceAndConstructors;

public class C extends B{
    public C(){
        // super();
        super(10);
        System.out.println("Constructor of C is getting executed");
    }
}

// super has to be the first line