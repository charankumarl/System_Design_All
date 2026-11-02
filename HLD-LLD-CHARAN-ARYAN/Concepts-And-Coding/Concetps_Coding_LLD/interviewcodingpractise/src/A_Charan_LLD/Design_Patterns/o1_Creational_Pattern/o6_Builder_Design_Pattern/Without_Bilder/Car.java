package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern.Without_Bilder;

public class Car implements Vehicles{

    // required
    private String engine;
    private int wheel;

    // optional
    private boolean airbags;
    private boolean musicSystem;

    public Car(String engine, int wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }

    public Car(String engine, int wheel, boolean airbags) {
        this.engine = engine;
        this.wheel = wheel;
        this.airbags = airbags;
    }

    public Car(String engine, int wheel, boolean airbags, boolean musicSystem) {
        this.engine = engine;
        this.wheel = wheel;
        this.airbags = airbags;
        this.musicSystem = musicSystem;
    }

    /*
        For each field we need to create a constructor. So if we have 10 fields, then we need to create 10! constructors.

        This is not a right approch, which will take more time and more memory.

        To avoid this we use Builder Design Pattern.

         Drawback → Too many overloaded constructors make the code hard to maintain.
     */
}
