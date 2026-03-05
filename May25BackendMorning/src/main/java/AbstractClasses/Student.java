package AbstractClasses;

public class Student {
    int id;
    String name;
    public static int counter = 0;

    Student(String name) {
        this.id = counter;
        counter++;
    }

    void normalMethod(){
        counter ++;
    }

    static void staticMethod(){
        // can't access normal attributes
//        name = "RandomName";
//        normalMethod();
    }
}
