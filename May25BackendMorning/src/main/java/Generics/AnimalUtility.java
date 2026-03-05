package Generics;

import InheritanceAndConstructors.A;

import java.util.List;

public class AnimalUtility {
//    public static void printAnimalsName(List<Animal> animalList){
//        for(Animal animal : animalList){
//            System.out.println(animal.getName());
//        }
//    }

    public static <T extends Animal> List<T> printAnimalsName(List<T> animalList){
        for(T animal : animalList){
            System.out.println(animal.getName());
        }
        return animalList;
    }

    public static void printAnimalsName2(List<? extends Animal> animalList){
        for(Animal animal : animalList){
            System.out.println(animal.getName());
        }
    }
}
// "?"
