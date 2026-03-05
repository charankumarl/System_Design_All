package InheritanceAndConstructors;

public class B extends A {
    int x;

    public B(){
//        this(5);
        // a1 = 5;
        // b1 = 10;
        // c1 = 20;
        // d1 = 51;
        // e1 = 70;
        // x = 90;
        System.out.println("Constructor of B is getting executed");
    }

    public B(int value){
        this(); // call the same class constructor
        x = value;
        System.out.println("Parameterised Constructor of B is getting executed");
    }
}
// this() and super() has to be in the first line
// You can only do one