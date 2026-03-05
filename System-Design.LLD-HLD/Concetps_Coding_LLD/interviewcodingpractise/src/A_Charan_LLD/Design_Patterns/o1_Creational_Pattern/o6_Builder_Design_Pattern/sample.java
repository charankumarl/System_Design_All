package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o6_Builder_Design_Pattern;

public class sample {

    int id;
    String name;
    int wheel;

    int add1;
    int add2;
    int add3;

    public sample(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.wheel = builder.wheel;
        this.add1 = builder.add1;
        this.add2 = builder.add2;
        this.add3 = builder.add3;
    }

    static class Builder{

        int id;
        String name;
        int wheel;

        int add1 = -1;
        int add2 = -1;
        int add3 = -1;

        public Builder(int id, String name, int wheel){
            this.id = id;
            this.name = name;
            this.wheel = wheel;
        }

        public Builder add_Add1(int add1){
            this.add1 = add1;
            return this;
        }

        public Builder add_Add2(int add2){
            this.add2 = add2;
            return this;
        }

        public Builder add_Add3(int add3){
            this.add3 = add3;
            return this;
        }

        public sample build(){
            sample sample = new sample(this);
            return sample;
        }
    }
}
