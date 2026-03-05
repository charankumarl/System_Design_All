package Generics;

import InheritanceAndConstructors.A;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        // first : firstName , second : psp
        Pair p = new Pair();
        p.setFirst("Mohit");
        p.setSecond(90.0);

        p.setSecond("Sharma");

        Double d = (Double)p.getSecond();

        GenericPair<String , Double> genericPair = new GenericPair<>();

        genericPair.setFirst("Mohit");
        genericPair.setSecond(90.0);

        GenericPair<String , String> genericPair2 = new GenericPair<>();
        genericPair2.setFirst("Mohit");
        genericPair2.setSecond("Sharma");
//        genericPair.setSecond("Sharma");

        // To support backward compatibility , if you don't provide
        // types , Object is taken as type by default
        GenericPair genericPair3 = new GenericPair<>();

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Kitoo"));
        animals.add(new Animal("XYZ"));
        animals.add(new Dog("Xapi", "GR"));

        List<Dog> animals2 = new ArrayList<>();
        animals2.add(new Dog("Xapi", "GR"));
        animals2.add(new Dog("Xapi2", "GR"));

        List<Integer> list = new ArrayList<>();
        AnimalUtility.printAnimalsName(animals2);
    }
}
