package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern;

public class Object_Reference {

    public static void main(String[] args) {

        b obj = new b();
        // we can access all the methods, m1 m2 m4.

        a obj1 = new b();
        // we can access only m1 and m2 methods, not m4.  because even though obj is
        // actually an instance of b, the compiler only knows it as type a, and m4() is not
        // visible through that reference.

        // solution

        ((b)obj1).m4();

        if (obj1 instanceof b) {
            ((b) obj1).m4(); // we can access m4 method by type casting.
        } else {
            System.out.println("obj1 is not an instance of b");
        }

        //a obj2 = new a();  // define the ansr=tract methods
        a obj2 = new a(){
            @Override
            void m2() {
                System.out.println("m2a");
            }
        };

        // we can only access methods in a, not m4, because obj2 is of type a.
    }
}

abstract class a{

    void m1(){
        System.out.println("m1a");
    }
    abstract void m2();
}

class b extends a{

    public void m4() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2");
    }
}

