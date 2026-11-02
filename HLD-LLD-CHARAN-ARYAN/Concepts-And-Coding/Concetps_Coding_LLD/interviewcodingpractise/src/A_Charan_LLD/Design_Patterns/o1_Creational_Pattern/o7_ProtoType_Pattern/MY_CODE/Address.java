package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern.MY_CODE;

public class Address implements Cloneable{

    String city;

    Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy is fine here since only one String field
    }

    @Override
    public String toString() {
        return city;
    }
}
