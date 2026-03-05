package accessModifier;

import IntroToOOP.Student;

public class IntelligentStudent extends Student {
    void accessProtectedAge(){
        // protected is accessible outside the package
        // only within the child class
        System.out.println(age);
//        System.out.println(id);
//        System.out.println(salary);
        System.out.println(name);
    }
}
