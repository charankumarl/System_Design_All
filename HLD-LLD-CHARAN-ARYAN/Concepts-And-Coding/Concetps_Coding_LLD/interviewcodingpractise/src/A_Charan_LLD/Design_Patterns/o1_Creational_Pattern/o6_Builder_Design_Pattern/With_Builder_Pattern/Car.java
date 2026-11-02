package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern.With_Builder_Pattern;

public class Car {

    private String engine;
    private int wheels;

    private boolean airbags;
    private boolean musicSystem;

    private Car(Builder builder){
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.airbags = builder.airbags;
        this.musicSystem = builder.musicSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", airBags=" + airbags +
                ", musicSystem=" + musicSystem +
                '}';
    }

    public static class Builder{

        private static String engine;
        private static int wheels;

        private static boolean airbags = false;
        private static boolean musicSystem = false;

        public Builder(String engine, int wheels){
            this.engine = engine;
            this.wheels = wheels;
        }

        public Builder addAirbags(){
            this.airbags = true;
            return this;   // return this means return the current instance of Builder. It is useful for chaining methods.
            /*
                If i dont return this, then i cant chain the methods. I cant call the methods one after the other.
                If we don't return this, chaining multiple builder methods won't work.

                Here, addAirbags() returns the Builder instance, so .setSunroof(true) can be called on it.

                If we don't return this, we would have to call methods separately:

                Builder builder = new Builder();    Chaining methods wont possible, since there will be no return type.
                builder.addAirbags();
                builder.setSunroof(true);
                Car car = builder.build();
             */
        }

        public Builder addMusicSystem(){
            this.musicSystem = true;
            return this;
        }

        public Car build(){
            return new Car(this);  // this keyword refers to the current instance of CarBuilder
        }

        /*
        The build() method creates a new Car object.
        The Car constructor (private Car(CarBuilder builder)) expects a CarBuilder object as a parameter.
        The this keyword inside build() refers to the current instance of CarBuilder.
        This allows the Car class to access all the fields set in the CarBuilder and use them to initialize its attributes.
         */
    }
}
