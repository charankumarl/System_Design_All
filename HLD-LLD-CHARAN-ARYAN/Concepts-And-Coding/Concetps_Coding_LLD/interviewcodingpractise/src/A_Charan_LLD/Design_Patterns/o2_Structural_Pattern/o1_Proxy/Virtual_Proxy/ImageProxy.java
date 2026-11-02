package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o1_Proxy.Virtual_Proxy;

public class ImageProxy implements Image {

    // Proxy that loads the image only when display() is called

    BigImage bigImage;
    String fileName;

    ImageProxy(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {

        if(bigImage == null){
            bigImage = new BigImage(fileName); // Lazy Loading
        }

        bigImage.display();
        System.out.println("object " + bigImage.toString());
    }
}
