package IntroToOOP;

public class Student {
    // data members / attributes
    int id;
   public String name;
   protected int age;
   private int salary;
   private Exam enrollmentExam;
   private Batch batch;

   public Student(){
   }

   public Student(String newName){
        id = 0;
        name = newName;
        age = 21;
        salary = 5000;
        enrollmentExam = new Exam(1 , 0);
   }

   public Student(String newName, int newSalary){
        id = 0;
        name = newName;
        salary = newSalary;
        age = 21;
        enrollmentExam = new Exam(1 , 0);
   }

   public Student(int newId, String newName ,int newAge, int newSalary){
       id = newId;
       name = newName;
       age = newAge;
       salary = newSalary;
       enrollmentExam = new Exam(1 , 0);
   }

   public Student(Student original){
        id = original.id;
        name = original.name;
        age = original.age;
        salary = original.salary;
        // it will not create a new exam object
//        enrollmentExam = original.enrollmentExam;
       // deep copy
        enrollmentExam = new Exam(original.enrollmentExam);
        // shallow copy
        batch = original.batch;

        // refVariable = refVariable2; => this will not create a new object

   }

   public int getSalary(){
       return salary;
   }

   public void setSalary(int salary){
       if(salary < 500){
           System.out.println("Sorry, this is an invalid value");
           return;
       }
       this.salary = salary;
   }
    // member functions / behaviour
    void attendClass(){
        System.out.println(name + " is attending class");
    }
}

// getters and setters


// public
// default
// protected
// private
