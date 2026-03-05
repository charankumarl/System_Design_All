package IntroToOOP;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Student student1 = new Student("John");
        // default is accessible outside the class
        // but within the same package
        student1.id = 1;
        student1.name = "John Doe";
        student1.age = 25;
        // can't access the private outside the class
//        student1.salary = 10000;
        student1.setSalary(1000);
        int sal = student1.getSalary();

        Student student2 = new Student("Jane");
        student2.id = 2;
        student2.name = "Jane Dol";
        student2.age = 26;

        Student student3 = new Student("Rohit", 5000000);
        System.out.println(student1);
        System.out.println(student1.name);

        // create a copy : Method 1

        Student stCopy = new Student();
        stCopy.id = student1.id;
        stCopy.name = student1.name;
        stCopy.age = student1.age;
//        stCopy.salary = student1.salary;
        stCopy.setSalary(student1.getSalary());

        // Method 2 : Copy constructor

        Student stCopy2 = new Student(student1);

        System.out.println("");
    }
}

// How it is controlled ? Who can do what ?
// access modifiers