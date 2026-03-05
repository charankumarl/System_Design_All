package accessModifier;

import IntroToOOP.Student;

public class Client {
    public static void main(String[] args) {
        Student student = new Student("Mohit");
//        student.salary = 5000;
        // default can't be accessed anywhere outside the package
//        student.id = 5;
        // can't access protected because it's not a child class of Student
//        student.age = 10;
        student.name = "Mohit Sharma";
    }
}
