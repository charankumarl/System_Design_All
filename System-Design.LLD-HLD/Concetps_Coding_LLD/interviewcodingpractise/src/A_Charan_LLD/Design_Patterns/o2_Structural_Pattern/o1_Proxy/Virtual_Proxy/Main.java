package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o1_Proxy.Virtual_Proxy;

public class Main {

    public static void main(String[] args) {

        Image img1 = new ImageProxy("c1");
        img1.display();// First call → Loads from disk

        img1.display();// Second call → Uses already loaded object
    }
}
