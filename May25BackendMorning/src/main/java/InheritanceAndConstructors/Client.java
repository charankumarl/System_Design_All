package InheritanceAndConstructors;

public class Client {
    public static void main(String[] args) {
        D d = new D();
        A a1 = new D();
        Util util = new Util();
        util.xyz(d);
        util.xyz(a1);
    }
}
// By default, java is calling the non-parameterised constructor of parent class
