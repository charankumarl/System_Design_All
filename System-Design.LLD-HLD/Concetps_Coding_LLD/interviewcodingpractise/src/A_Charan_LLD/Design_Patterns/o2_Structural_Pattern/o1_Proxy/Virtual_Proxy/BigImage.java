package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o1_Proxy.Virtual_Proxy;

public class BigImage implements Image {

    private String fileName;

    public BigImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();  // Simulating heavy operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + fileName);
    }
}
